<#--  niushuai 2019-05-08 01:59:37-->

<html>
<head>
    <title>课程评论详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-label-left">评论ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.commentId)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">发表用户<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createBy)!"-"}</label>
        </div>

        <div class="layui-form-item" >
            <label class="layui-label-left">评论内容<span class="label_span">:</span></label>
            <label class="layui-label-right" style="width: 500px;">${(model.content)!"-"}</label>
        </div>

        <div class="layui-form-item">
            <label class="layui-label-left">点赞量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.praiseCount)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">回复量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.replyCount)!"-"}</label>
        </div>

    </form>
</div>

</body>
</html>
