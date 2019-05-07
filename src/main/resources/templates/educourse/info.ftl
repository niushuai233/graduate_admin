<#--  niushuai 2019-05-07 13:44:30-->

<html>
<head>
    <title>课程表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-label-left">课程编号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.courseId)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.courseName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">1正常2删除<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.isAvaliable)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程专业ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.subjectId)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程专业链<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.subjectLink)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">添加时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.addTime)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程原价格（只显示）<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sourcePrice)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程销售价格（实际支付价格）设置为0则可免费观看<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.currentPrice)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程简介<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.title)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">课程详情<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.context)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">总课时<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.lessionNum)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">图片路径<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.logo)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">最后更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">销售数量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.pageBuycount)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">浏览数量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.pageViewcount)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">有效结束时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.endTime)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">有效期类型，0：到期时间，1：按天数<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.losetype)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">有效期:商品订单过期时间点<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.loseTime)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">序列<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sequence)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">该课程总共卖了多少钱（新加字段暂时没用到）<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.courseGrossIncome)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">更新人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateBy)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">创建人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createBy)!"-"}</label>
        </div>
    </form>
</div>

</body>
</html>
