<#--  niushuai 2019-05-07 01:07:31-->

<html>
<head>
    <title>文章内容表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">文章ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.articleId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章内容<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.content)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
