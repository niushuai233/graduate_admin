<#--  niushuai 2019-05-07 00:16:25-->

<html>
<head>
    <title>问答评论详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">主键id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">评论人id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.cusId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">评论人昵称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.cusName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">问答id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.questionId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">评论内容<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.content)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">是否最佳答案 0否1是<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.isBest)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">回复数量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.replyCount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">点赞数<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.praiseCount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">回复时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.addTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">父级评论id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.commentId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">0禁用 1启用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.state)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateBy)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
