<#--  niushuai 2019-05-07 22:08:20-->

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
            <label class="layui-label-left">课程id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.courseId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">分类id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.subjectId)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
