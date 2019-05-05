<#--  niushuai 2019-05-05 23:22:24-->

<html>
<head>
    <title>讲师详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">教师ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">教师名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.name)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">教师资历,一句话说明老师<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.education)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">教师简介<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.career)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">头衔 1高级讲师2首席讲师<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.isStar)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">图片路径<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.picPath)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态:0正常1删除<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">专业ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.subjectId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">排序<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sort)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateBy)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
