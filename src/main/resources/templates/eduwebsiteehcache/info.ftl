<#--  niushuai 2019-05-05 22:47:34-->

<html>
<head>
    <title>详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">主键<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">ehcache key<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.ehcacheKey)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">描述<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.ehcacheDesc)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
