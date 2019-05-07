<#--  章节管理公用页面-->
<#--  niushuai 2019-05-08 02:51:58-->

<div class="layui-form-item">
    <label class="layui-form-label">选择课程<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="url:'/educourse/findAllCourseSelectTool',multiple:'false', filter:'courseIdTool'"
             value="${(model.courseId)!""}" name="courseId" class="layui-input-normal"></div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">选择节点<span class="span_must">*</span></label>
    <div class="layui-input-normal">

        <input value="${(model.name)!""}" id="name" cyType="treeTool" cyProps="url:'/educoursekpoint/selectTreeTool/000',name:'name'" readonly
               placeholder="请选择节点" class="layui-input"/>
    </div>
</div>

<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label">父级ID<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="parentId" maxlength="11" lay-verify="required"
               value="${(model.parentId)!""}" placeholder="请输入父级ID" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">排序<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="sort" maxlength="11" lay-verify="required"
               value="${(model.sort)!""}" placeholder="请输入排序" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">播放次数<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="playCount" maxlength="11" lay-verify="required"
               value="${(model.playCount)!""}" placeholder="请输入播放次数" class="layui-input">
    </div>
</div>

<div class="layui-form-item" style="display: none">
    <label class="layui-form-label">是否可以试听<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="isFree" maxlength="1" lay-verify="required"
               value="1" placeholder="请输入是否可以试听" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">视频地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="videoUrl" maxlength="500" lay-verify="required" readonly
               value="${(model.videoUrl)!""}" placeholder="请上传视频获取地址" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">选择讲师<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="url:'/eduteacher/findAllTeacherSelectTool',multiple:'false'"
             value="${(model.teachers)!""}" name="teacherArray" class="layui-input-normal"></div>
    </div>
</div>

<#--<div class="layui-form-item">
    <label class="layui-form-label">总计播放时间<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="playTime" maxlength="100" lay-verify="required"
               value="${(model.playTime)!""}" placeholder="请输入总计播放时间" class="layui-input">
    </div>
</div>-->

<div class="layui-form-item">
    <label class="layui-form-label">节点类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="codeName:'kpointType',search:'false',filter:'demo'"
             name="kpointType" value="${(model.kpointType)!"0"}" class="layui-input-inline"></div>
    </div>
</div>

<#--
<div class="layui-form-item">
    <label class="layui-form-label">视频类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="videoType" maxlength="30" lay-verify="required"
               value="${(model.videoType)!""}" placeholder="请输入视频类型" class="layui-input">
    </div>
</div>
-->

<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label">VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="fileType" maxlength="20" lay-verify="required"
               value="VIDEO" placeholder="请输入VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集"
               class="layui-input">
    </div>
</div>


<script type="text/javascript" src="/educoursekpoint/js/other.js"></script>
