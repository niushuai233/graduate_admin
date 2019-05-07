<#--  niushuai 2019-05-08 01:08:50-->

<html>
<head>
    <title>推荐课程表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <input type="hidden" name="ID" value="${(model.id)!"-"}">
        <div class="layui-form-item">
            <label class="layui-label-left">课程id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.courseId)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程显示排序<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.orderNum)!"-"}</label>
        </div>

      </form>
</div>
</body>
</html>
