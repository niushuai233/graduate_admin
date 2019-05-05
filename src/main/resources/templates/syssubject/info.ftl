<#--  niushuai 2019-05-06 01:56:41-->

<html>
<head>
    <title>专业信息详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">主键<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.subjectId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">专业名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.subjectName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">父ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.parentId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">排序<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sort)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态 0:默认 1:删除<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
