<#--  讲师公用页面-->
<#--  niushuai 2019-05-05 23:22:24-->
<link rel="stylesheet" href="/statics/plugins/cropperjs/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/statics/plugins/cropperjs/css/cropper/cropper.css">
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
    <label class="layui-form-label mylable mylable">上传图片<span class="span_must">*</span></label>
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
    <label class="layui-form-label mylable">姓名<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="name" maxlength="30" lay-verify="required"
               value="${(model.name)!""}" placeholder="请输入教师名称" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label mylable">图片路径<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="picPath" maxlength="255" lay-verify="required" readonly
               value="${(model.picPath)!""}" placeholder="请输入图片路径" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">资历<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="education" maxlength="255" lay-verify="required"
               value="${(model.education)!""}" placeholder="请输入教师资历,一句话说明老师" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">教师简介<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <textarea name="career" lay-verify="required"
                  placeholder="请输入教师简介" class="layui-textarea">${(model.career)!""}</textarea>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">头衔<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="codeName:'isStar',search:'true',filter:'isStar'"
             name="isStar" value="1" class="layui-input-inline"></div>
    </div>
</div>


<div class="layui-form-item">
    <label class="layui-form-label mylable">讲师专业<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input value="${(model.subjectId)!""}" id="subjectId" name="subjectId" cyType="treeTool" cyProps="url:'/syssubject/selectTreeTool',name:'subjectId'"
               placeholder="请选择专业" class="layui-input"/>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">排序<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="sort" maxlength="2" lay-verify="required"
               value="${(model.sort)!""}" placeholder="请输入排序" class="layui-input">
    </div>
</div>

<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label mylable">状态</label>
    <input type="hidden" value="0" name="status">
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

<script type="text/javascript" src="/eduteacher/js/other.js"></script>
<script type="text/javascript" src="/statics/plugins/cropperjs/js/bootstrap/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/statics/plugins/cropperjs/js/cropper/cropper.js"></script>
<script type="text/javascript" src="/eduteacher/js/cropper.my.js"></script>