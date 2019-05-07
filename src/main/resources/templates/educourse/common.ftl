<#--  课程表公用页面-->
<#--  niushuai 2019-05-07 13:44:30-->
<link rel="stylesheet" href="/statics/plugins/cropperjs/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/statics/plugins/cropperjs/css/cropper/cropper.css">
<link rel="stylesheet" type="text/css" href="/statics/plugins/editor.md/css/editormd.css">

<style>
    .mylable {
        width: 150px;
    }

    .label {
        cursor: pointer;
    }

    .progress {
        display: none;
        margin-bottom: 1rem;
    }

    .alert {
        display: none;
    }

    .img-container img {
        max-width: 100%;
    }
</style>
<div class="layui-form-item">
    <label class="layui-form-label mylable">课程名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="courseName" maxlength="300" lay-verify="required"
               value="${(model.courseName)!""}" placeholder="请输入课程名称" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">课程专业<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input value="${(model.subjectId)!""}" id="subjectId" cyType="treeTool" cyProps="url:'/syssubject/selectTreeTool',name:'subjectId'"
               placeholder="请选择课程专业" class="layui-input"/>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">选择讲师<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="url:'/eduteacher/findAllTeacherSelectTool',multiple:'true'"
             value="${(model.teachers)!""}" name="teacherArray" class="layui-input-normal"></div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">课程简介<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <textarea type="text" name="title" maxlength="255" lay-verify="required"
                  placeholder="请输入课程简介" class="layui-textarea">${(model.title)!""}</textarea>
    </div>
</div>


<div class="layui-form-item">
    <label class="layui-form-label mylable">序列<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="sequence" maxlength="1" lay-verify="required"
               value="${(model.sequence)!""}" placeholder="请输入序列" class="layui-input">
    </div>
</div>

<#--

<div class="layui-form-item">
    <label class="layui-form-label mylable">总课时<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="lessionNum" maxlength="20" lay-verify="required"
               value="${(model.lessionNum)!""}" placeholder="请输入总课时" class="layui-input">
    </div>
</div>
-->
<div class="layui-form-item">
    <label class="layui-form-label mylable mylable mylable">上传图片<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <label class="label" data-toggle="tooltip" title="选择一张图片">
            <img class="rounded" id="avatar" src="${(fdfsAccessPrefix)!"/statics/plugins/cropperjs/images/picture.jpg"}"
                 alt="avatar" style="width:288px; height: 288px;">
            <input type="file" class="sr-only" id="input" accept="image/*" data-id="file" data-filename="filename.jpg">
        </label>
        <div class="progress" style="width:255px;">
            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="0"
                 aria-valuemin="0" aria-valuemax="100">0%
            </div>
        </div>
        <div class="alert" role="alert" style="width:255px;"></div>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label mylable">图片路径<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="logo" maxlength="50" lay-verify="required" readonly
               value="${(model.logo)!""}" placeholder="请输入图片路径" class="layui-input">
    </div>
</div>


<div class="layui-form-item">
    <label class="layui-form-label mylable">浏览数量<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="pageViewcount" maxlength="20" lay-verify="required"
               value="${(model.pageViewcount)!""}" placeholder="请输入浏览数量" class="layui-input">
    </div>
</div>

<textarea id="md" style="display: none;">${(model.markdown)!""}</textarea>
<div id="editormdDiv">
    <textarea style="display:none;" name="markdown" class="editormd-markdown-textarea"></textarea>
    <textarea style="display:none;" name="html" class="editormd-html-textarea"></textarea>

</div>
<div class="layui-form-item">
    <label class="layui-form-label mylable">状态</label>
    <div cyType="radioTool" cyProps="enumName:'CourseEnum'" name="isAvaliable"
         value="${(model.isAvaliable)!"1"}" class="layui-input-inline"></div>
</div>

<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">图片裁剪</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="img-container">
                    <img id="image" src="">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="crop">裁剪</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/statics/plugins/cropperjs/js/bootstrap/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/statics/plugins/cropperjs/js/cropper/cropper.js"></script>
<script type="text/javascript" src="/educourse/js/cropper.my.js"></script>
<script type="text/javascript" src="/statics/plugins/editor.md/editormd.js"></script>
<script type="text/javascript" src="/statics/plugins/editor.md/initEditor.js"></script>
<script type="text/javascript" src="/educourse/js/other.js"></script>
