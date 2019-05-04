
function initEditor(url, content, w, h) {
    var editor = editormd("editormdDiv", {
        width: w,                           // 宽度
        height: h,                          // 高度
        markdown : content,                 // 初始化时显示的内容
        path : '/statics/plugins/editor.md/lib/',
        //dialogLockScreen : false,         // 设置弹出层对话框不锁屏，全局通用，默认为 true
        dialogShowMask : true,              // 设置弹出层对话框显示透明遮罩层，全局通用，默认为 true
        //dialogDraggable : false,          // 设置弹出层对话框不可拖动，全局通用，默认为 true
        //dialogMaskOpacity : 0.4,          // 设置透明遮罩层的透明度，全局通用，默认值为 0.1
        //dialogMaskBgColor : "#000",       // 设置透明遮罩层的背景颜色，全局通用，默认为 #fff
        imageUpload : true,                 // 是否开启图片上传
        imageFormats : ["jpg", "jpeg", "gif",
            "png", "bmp"],                  // 接收的image图片类型
        imageUploadURL : url,               // 图片上传url
        emoji: true,                        // 开启emoji表情
        saveHTMLToTextarea: true,           // post提交表单\
        syncScrolling : "single",           // 锁定scrolling
    });

    return editor;
}
