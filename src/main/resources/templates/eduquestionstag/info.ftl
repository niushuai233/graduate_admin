<#--  niushuai 2019-05-06 13:48:05-->

<html>
<head>
    <title>问答标签详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">主键id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.questionsTagId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">标签名<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.questionsTagName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">父级id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.parentId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">父级标签名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.parentName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态0默认1删除<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">标签创建时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateBy)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
