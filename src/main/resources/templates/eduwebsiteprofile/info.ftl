<#--  niushuai 2019-04-29 12:58:02-->

<html>
<head>
    <title>详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">类型<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.type)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">内容JSON格式<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.desciption)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">说明<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.explain)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">0禁用 1启用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.state)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createDate)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateDate)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
