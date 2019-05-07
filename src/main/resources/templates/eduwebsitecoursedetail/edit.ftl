<#--  niushuai 2019-05-08 01:08:50-->

<html>
<head>
    <title>推荐课程表修改页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">课程名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  maxlength="20" lay-verify="required"
                       value="${(model.courseName)!""}"  placeholder="请输入课程id"  class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">课程显示排序<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="orderNum" maxlength="20" lay-verify="required"
                       value="${(model.orderNum)!""}"  placeholder="请输入课程显示排序"  class="layui-input">
            </div>
        </div>
        <script type="text/javascript" src="/eduwebsitecoursedetail/js/other.js"></script>
        <input type="hidden" name="id" value="${model.id}">
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/eduwebsitecoursedetail/update"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>

