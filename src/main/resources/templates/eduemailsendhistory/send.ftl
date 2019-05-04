<#--  niushuai 2019-05-03 12:16:04-->

<html>
<head>
    <title>邮件发送记录修改页面</title>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" type="text/css" href="/statics/plugins/editor.md/css/editormd.css">
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <#--  邮件发送记录公用页面-->
        <#--  niushuai 2019-05-03 12:16:04-->
        <div class="layui-form-item">
            <label class="layui-form-label">接收人<span class="span_must">*</span></label>
            <div class="layui-input-normal">

                <div cyType="selectTool" cyProps="url:'/sys/user/findAllUseSelectTool',multiple:'true',search:'true',filter:'email'" placeholder="请选择接收人"
                     value="${(model.email)!""}" name="email" class="layui-input-normal"></div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮件标题<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text" name="title" maxlength="300" lay-verify="required"
                       value="" placeholder="请输入邮件标题" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">定时发送时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text" id="sendTime" name="sendTime" maxlength="20" lay-verify="" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readonly:'true',minDate:getCurrDate()})"
                       value="${(model.sendTime)!""}" placeholder="yyyy-MM-dd HH:mm:ss" class="layui-input Wdate">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮件类型<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="codeName:'mailSendType',search:'true', filter:'mailSendTypeFilter'" name="type"
                     value="${(model.type)!"1"}" class="layui-input-inline" ></div>

            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮件正文<span class="span_must">*</span></label>
            <label class="layui-form-label" style="width: 30%;"><span class="span_must">请不要使用过于复杂的内容,否则邮件发出后与在此处预览看到的效果并不同</span></label>
            <div id="editormdDiv">
                <textarea style="display:none;" name="markdown" class="editormd-markdown-textarea"></textarea>
                <textarea style="display:none;" name="html" class="editormd-html-textarea"></textarea>

            </div>
        </div>

        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/eduemailsendhistory/send">
                        <i class="fa fa-floppy-o">&nbsp;</i>发送
                    </button>
                </div>
            </div>
        </div>
    </form>

    <script type="text/javascript" src="/statics/plugins/editor.md/editormd.js"></script>
    <script type="text/javascript" src="/statics/plugins/editor.md/initEditor.js"></script>
    <script type="text/javascript" src="/eduemailsendhistory/js/other.js"></script>
</div>

</body>
</html>

