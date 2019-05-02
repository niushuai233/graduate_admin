<#--  niushuai 2019-05-02 17:16:49-->

<html>
<head>
    <title>导航表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">导航显示名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.name)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">导航显示位置<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.url)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">是否在新页面打开0是1否<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.newpage)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">类型：INDEX首页、USER个人中心、FRIENDLINK尾部友链、TAB尾部标签<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.type)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">显示排序<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.ordernum)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">0正常1冻结<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
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
