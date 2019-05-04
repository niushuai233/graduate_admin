<#--  niushuai 2019-05-03 12:16:04-->

<html>
<head>
    <title>邮件发送记录详情页面</title>
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
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.email)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">邮箱标题<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.title)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">邮箱正文<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.content)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">定时发送时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sendTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">1 已发送 2 未发送<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">1 普通 2 定时<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.type)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建日期<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createDate)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新日期<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateDate)!"-"}</label>
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
