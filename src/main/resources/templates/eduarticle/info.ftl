<#--  niushuai 2019-05-07 01:07:31-->

<html>
<head>
    <title>文章信息表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left">文章ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.articleId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章标题<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.title)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章摘要<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.summary)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章关键字<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.keyWord)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章图片URL<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.imageUrl)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章来源<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.source)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章作者<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.author)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章发布时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.publishTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章访问链接<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.link)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章类型 2文章<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.articleType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章点击量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.clickNum)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">点赞数量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.praiseCount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">评论数<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.commentNum)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">排序值<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sort)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">0禁用 1启用<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.state)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">创建人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文章创建时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateBy)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">更新时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateDate)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
