<#--  niushuai 2019-05-08 02:51:58-->

<html>
<head>
    <title>章节管理详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.kpointId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">课程id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.courseId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">节点名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.name)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">父级ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.parentId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">添加时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.addTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">显示排序<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sort)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">播放次数<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.playCount)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">是否可以试听1免费2收费<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.isFree)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">视频地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.videoUrl)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">讲师id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.teacherId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">播放时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.playTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">节点类型 0文件目录 1视频<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.kpointType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">视频类型<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.videoType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.fileType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">文本<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.content)!"-"}</label>
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
