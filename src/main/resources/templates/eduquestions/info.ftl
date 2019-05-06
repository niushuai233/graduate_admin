<#--  niushuai 2019-05-06 21:39:25-->

<html>
<head>
    <title>问答详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">主键<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建人id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.cusId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">问答标题<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.title)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">问答内容<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.content)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">分类 1课程问答 2 学习分享<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.type)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">状态 0可回复1不可回复（采纳最佳答案后改为1 ）<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.status)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">问答回复数量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.replyCount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">问答浏览次数<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.browseCount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">问答点赞数量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.praiseCount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">0删除 1启用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.state)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">添加时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.addTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
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
