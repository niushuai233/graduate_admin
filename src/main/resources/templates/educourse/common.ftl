<#--  课程表公用页面-->
<#--  niushuai 2019-05-07 13:44:30-->

<div class="layui-form-item">
    <label class="layui-form-label">课程名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="courseName" maxlength="300" lay-verify="required"
               value="${(model.courseName)!""}" placeholder="请输入课程名称" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">课程专业<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input value="${(model.subjectId)!""}" id="subjectId" cyType="treeTool" cyProps="url:'/syssubject/selectTreeTool',name:'subjectId'"
               placeholder="请选择课程专业" class="layui-input"/>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">课程简介<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <textarea type="text" name="title" maxlength="255" lay-verify="required"
                  placeholder="请输入课程简介" class="layui-textarea">${(model.title)!""}</textarea>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">课程详情<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="context" maxlength="20" lay-verify="required"
               value="${(model.context)!""}" placeholder="请输入课程详情" class="layui-input">
    </div>
</div>


<div class="layui-form-item">
    <label class="layui-form-label">序列<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="sequence" maxlength="1" lay-verify="required"
               value="${(model.sequence)!""}" placeholder="请输入序列" class="layui-input">
    </div>
</div>

<#--

<div class="layui-form-item">
    <label class="layui-form-label">总课时<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="lessionNum" maxlength="20" lay-verify="required"
               value="${(model.lessionNum)!""}" placeholder="请输入总课时" class="layui-input">
    </div>
</div>
-->

<div class="layui-form-item">
    <label class="layui-form-label">图片路径<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="logo" maxlength="50" lay-verify="required"
               value="${(model.logo)!""}" placeholder="请输入图片路径" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">选择讲师<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="url:'/eduteacher/findAllTeacherSelectTool',multiple:'true'"
             value="${(model.teachers)!""}" name="teachers" class="layui-input-normal"></div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">浏览数量<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="pageViewcount" maxlength="20" lay-verify="required"
               value="${(model.pageViewcount)!""}" placeholder="请输入浏览数量" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'CourseEnum'" name="isAvaliable"
         value="${(model.isAvaliable)!"1"}" class="layui-input-inline"></div>
</div>
<script type="text/javascript" src="/educourse/js/other.js"></script>
