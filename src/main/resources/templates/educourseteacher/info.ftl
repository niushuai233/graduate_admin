<#--  niushuai 2019-05-07 22:06:27-->

<html>
<head>
    <title>课程讲师关联详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">课程id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.courseId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">讲师id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.teacherId)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
