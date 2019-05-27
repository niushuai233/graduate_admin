window.addEventListener('DOMContentLoaded', function () {
    // id为avatar的默认图片显示image
    var avatar = document.getElementById('avatar');
    // id为image的裁剪容器
    var image = document.getElementById('image');
    // id为input的隐藏文件
    var input = document.getElementById('input');
    // 进度条相关内容
    var $progress = $('.progress');
    var $progressBar = $('.progress-bar');
    var $alert = $('.alert');
    var $modal = $('#modal');
    // 实例化一个cropper属性
    var cropper;

    $('[data-toggle="tooltip"]').tooltip();
    // 文件选择添加change事件
    input.addEventListener('change', function (e) {
        // 获取选择的文件
        var files = e.target.files;
        var done = function (url) {
            input.value = '';
            image.src = url;
            $alert.hide();
            $modal.modal('show');
        };
        var reader;
        var file;
        var url;

        if (files && files.length > 0) {
            file = files[0];

            if (URL) {
                done(URL.createObjectURL(file));
            } else if (FileReader) {
                reader = new FileReader();
                reader.onload = function (e) {
                    done(reader.result);
                };
                reader.readAsDataURL(file);
            }
        }
    });
    // 显示模态框的时候初始化cropper
    $modal.on('shown.bs.modal', function () {
        cropper = new Cropper(image, {
            // 纵横比率即宽高比 1代表为1:1裁剪
            aspectRatio: 0,
            // 0代表无限制
            // 1代表限制裁剪框不超过画布的大小。
            // 2代表裁剪框不能超出图片范围大小 且图片不会填充满容器
            // 3代表裁剪框不能超出图片范围大小 且图片会填充满容器
            viewMode: 3,
        });
    }).on('hidden.bs.modal', function () {
        // 模态框隐藏的时候销毁cropper
        cropper.destroy();
        cropper = null;
    });
    // 裁剪按钮添加监听事件
    document.getElementById('crop').addEventListener('click', function () {
        var initialAvatarURL;
        var canvas;

        $modal.modal('hide');

        if (cropper) {
            canvas = cropper.getCroppedCanvas({
                // 裁剪之后输出的宽度和高度
                width: 1024,
                height: 255,
            });
            initialAvatarURL = avatar.src;
            // base64编码的数据 传递到后台时需要将数据转成image图片
            avatar.src = canvas.toDataURL();
            $progress.show();
            $alert.removeClass('alert-success alert-warning');
            canvas.toBlob(function (blob) {
                var formData = new FormData();
                // 指定文件字段名 以及 文件名 通过id的input的input标签的data-id属性与data-filename属性设置值
                formData.append($('#input').attr("data-id"), blob, $('#input').attr("data-filename"));
                // 该url指向测试restful的接口地址
                $.ajax('/eduwebsiteimages/imageUpload', {
                    method: 'POST',
                    data: formData,
                    processData: false,
                    contentType: false,
                    // 显示进度条
                    xhr: function () {
                        var xhr = new XMLHttpRequest();

                        xhr.upload.onprogress = function (e) {
                            var percent = '0';
                            var percentage = '0%';

                            if (e.lengthComputable) {
                                percent = Math.round((e.loaded / e.total) * 100);
                                percentage = percent + '%';
                                $progressBar.width(percentage).attr('aria-valuenow', percent).text(percentage);
                            }
                        };

                        return xhr;
                    },
                    // 成功回调
                    success: function (data) {
                        console.log(data);
                        if (0 == data.code) {
                            $("input[name='imageUrl']").val(data.msg);
                            $alert.show().addClass('alert-success').text('上传成功');
                        } else {
                            $alert.show().addClass('alert-success').text('上传成功');
                        }
                    },
                    // 失败回调
                    error: function () {
                        avatar.src = initialAvatarURL;
                        $alert.show().addClass('alert-warning').text('上传失败');
                    },
                    // 无论成功或失败
                    complete: function () {
                        $progress.hide();
                    },
                });
            });
        }
    });
});