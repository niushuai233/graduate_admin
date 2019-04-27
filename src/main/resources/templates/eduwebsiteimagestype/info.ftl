<#--  niushuai 2019-03-19 16:36:50-->

<html>
<head>
    <title>图片类型表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">类型ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.typeId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">类型名<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.typeName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态 0禁用 1启用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.state)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createDate)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateDate)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
