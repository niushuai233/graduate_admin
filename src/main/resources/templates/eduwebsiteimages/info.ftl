<#--  niushuai 2019-03-19 16:36:50-->

<html>
<head>
    <title>banner图管理详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.imageId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">图片地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.imageUrl)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">图链接地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.linkAddress)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">图标题<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.title)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">图片类型<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.typeId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">序列号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.seriesNumber)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">略缩图片地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.previewUrl)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">背景色<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.color)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">图片描述<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.describe)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态 0禁用 1启用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.state)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
