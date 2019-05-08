/**
 * Created by 陈熠 on 2017/8/22
 *
 * 上传控件
 */
(function ($) {
    /* 入口函数 */
    $.fn.fileUploadTool = function () {
        //当前对象
        var $grid = this;
        //获取参数
        cyProps = $grid.attr("cyProps");
        cyProps = cyProps ? cyProps : "";
        //将参数转为json
        cyProps = eval("({" + cyProps + "})");

        //上传控件类型
        var type = cyProps.multiple || false;
        if (type == "true") {
            //如果是多文件
            fileUploadTool.renderMultiple($grid, cyProps);
        } else {
            //如果是单文件
            fileUploadTool.renderSingle($grid, cyProps);
        }

    };
    /*默认配置*/
    var cyProps = {};
    /*方法对象*/
    var fileUploadTool = {
        /**渲染上传控件(上传多个文件) by niushuai 2017/8/22*/
        renderMultiple: function ($grid, cyProps) {
            var _url = cyProps.url || "/getData/upload/";
            var _uploadId = $t.getUUID(32, 16);
            var _btnName = cyProps.btnName || "上传文件";
            var _name = cyProps.name || "";
            var _value = cyProps.value || "";
            var _type = cyProps.type || "";
            var _size = cyProps.size || 500000;
            var _exts = cyProps.exts || "";
            $grid.html(['<button type="button" class="layui-btn" id="' + _uploadId + '">',
                ' <i class="fa fa-cloud-upload">&nbsp;</i>' + _btnName,
                '</button>',
                ' </div>'].join(""));

            layui.use('upload', function () {
                var upload = layui.upload;
                //执行实例
                upload.render({
                    elem: '#' + _uploadId  //绑定元素
                    , multiple: true
                    , size: _size //限制文件大小，单位 KB
                    , accept: _type //接受的文件类型
                    , exts: _exts //只允许上传压缩文件
                    , url: _url           //上传接口
                    , done: function (res) {
                        //上传完毕回调
                        if (res.code === 0) {
                            $("#" + _uploadId + "_imgs").append(
                                ['<div class="file-div">',
                                    '<img class="layui-upload-img"   src="' + res.url + '">',
                                    '<input type="hidden" name="' + _name + ' ">',
                                    '<div class="file-delete" ><span class="delete-list"> ',
                                    '<i class="fa fa-undo"></i>',
                                    '<i class="fa fa-repeat"></i>',
                                    '<i class="fa fa-trash-o"></i></span></div>',
                                    '</div>'].join(""));
                            Msg.success("上传成功");
                        } else {
                            Msg.error(res.msg);
                        }
                    }
                    , error: function () {
                        //请求异常回调
                        Msg.error("系统繁忙");
                    }
                });
            });

        },
        /**渲染上传控件(上传单个文件) by 2017/8/22*/
        renderSingle: function ($grid, cyProps) {
            var _url = cyProps.url || "/getData/uploadFile/";
            var _uploadId = $t.getUUID(32, 16);
            var _btnName = cyProps.btnName || "上传图片";
            var _name = cyProps.name || "";
            var _value = cyProps.value || "";
            var _size = cyProps.size || 1000;
            var _type = cyProps.type || "img";
            var _exts = cyProps.exts || "";
            $grid.html(['<button type="button" class="layui-btn" id="' + _uploadId + '">',
                ' <i class="fa fa-cloud-upload">&nbsp;</i>' + _btnName,
                '</button>',
                ].join(""));
            layui.use('upload', function () {
                var upload = layui.upload;
                //执行实例
                upload.render({
                    elem: '#' + _uploadId  //绑定元素
                    , size: _size //限制文件大小，单位 KB
                    , accept: _type //接受的文件类型
                    , exts: _exts //只允许上传压缩文件
                    , url: _url           //上传接口
                    , done: function (res) {
                       //上传完毕回调U
                        if (res.code === 0) {
                            $("#videoUrl").val(res.msg);
                            Msg.success('上传成功');
                        } else {
                            Msg.error(res.msg);
                        }
                    }
                    , error: function () {
                        //请求异常回调
                        Msg.error("系统繁忙");
                    }
                });
            });
        }
    }

})(jQuery);


$(document).ready(function () {
    $("[cyType='fileUploadTool']").click(function () {
        var uploadId = $(this).attr("uploadId");
        $("#" + uploadId + "File").val("");
        $("#" + uploadId + "File").click();
    });

    //上传控件
    var uploads = $("[cyType='fileUploadTool']");
    for (var i = 0; i < uploads.length; i++) {
        $(uploads[i]).fileUploadTool();
    }
});

