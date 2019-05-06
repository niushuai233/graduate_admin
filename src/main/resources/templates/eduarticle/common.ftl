<#--  文章信息表公用页面-->
<#--  niushuai 2019-05-07 01:07:31-->

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
    <label class="layui-form-label mylable">文章标题<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="title" maxlength="100" lay-verify="required"
               value="${(model.title)!""}" placeholder="请输入文章标题" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">文章摘要<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="summary" maxlength="200" lay-verify="required"
               value="${(model.summary)!""}" placeholder="请输入文章摘要" class="layui-input">
    </div>
</div>
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
    <label class="layui-form-label mylable">URL<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="imageUrl" maxlength="100" lay-verify="required" readonly
               value="${(model.imageUrl)!""}" placeholder="请输入文章图片URL" class="layui-input">
    </div>
</div>

<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label mylable">文章类型 2文章<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="hidden" name="articleType" maxlength="4" lay-verify="required"
               value="2" placeholder="请输入文章类型 2文章" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label mylable">点击量<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 100px;">
        <input type="text" name="clickNum" maxlength="11" lay-verify="required"
               value="${(model.clickNum)!"0"}" placeholder="请输入文章点击量" class="layui-input">
    </div>

    <label class="layui-form-label mylable">点赞量<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 100px;">
        <input type="text" name="praiseCount" maxlength="11" lay-verify="required"
               value="${(model.praiseCount)!"0"}" placeholder="请输入点赞数量" class="layui-input">
    </div>

    <label class="layui-form-label mylable">评论量<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 100px;">
        <input type="text" name="commentNum" maxlength="11" lay-verify="required"
               value="${(model.commentNum)!"0"}" placeholder="请输入评论数" class="layui-input">
    </div>

    <label class="layui-form-label mylable">排序值<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 100px;">
        <input type="text" name="sort" maxlength="11" lay-verify="required"
               value="${(model.sort)!""}" placeholder="请输入排序值" class="layui-input">
    </div>
</div>

<textarea id="md" style="display: none;">${(model.markdown)!""}</textarea>
<div id="editormdDiv">
    <textarea style="display:none;" name="markdown" class="editormd-markdown-textarea"></textarea>
    <textarea style="display:none;" name="html" class="editormd-html-textarea"></textarea>

</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
         value="${(model.state)!"1"}" class="layui-input-inline"></div>
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
<script type="text/javascript" src="/eduteacher/js/cropper.my.js"></script>
<script type="text/javascript" src="/statics/plugins/editor.md/editormd.js"></script>
<script type="text/javascript" src="/statics/plugins/editor.md/initEditor.js"></script>
<script type="text/javascript" src="/eduquestions/js/other.js"></script>
