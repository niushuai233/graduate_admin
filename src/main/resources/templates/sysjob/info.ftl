<#--  niushuai 2019-05-05 10:06:03-->

<html>
<head>
    <title>Cron任务详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">任务名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.jobName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">cron表达式<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.cron)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">是否启动 0 未启动 1 已启动<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.started)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">是否需要重复执行<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.recycle)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">执行路径<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.clazzPath)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">任务描述<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.jobDesc)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">删除标志 0已删除 1未删除<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.state)!"-"}</label>
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
