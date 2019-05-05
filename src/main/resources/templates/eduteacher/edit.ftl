<#--  niushuai 2019-05-05 23:22:24-->

<html>
<head>
    <title>讲师修改页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
       <#include "common.ftl"/>
        <input type="hidden" name="id" value="${model.id}">
        <div class="page-footer">
            <div class="btn-list" style="height: 75px;">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/eduteacher/update"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>

