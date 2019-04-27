<#--  banner图管理公用页面-->
<#--  niushuai 2019-03-19 16:36:50-->
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
    <label class="layui-form-label mylable">上传图片<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <label class="label" data-toggle="tooltip" title="选择一张图片">
            <img class="rounded" id="avatar" src="${(model.imageUrl)!"/statics/plugins/cropperjs/images/picture.jpg"}" alt="avatar" style="width:255px; height: 255px;">
            <input type="file" class="sr-only" id="input" accept="image/*" data-id="file" data-filename="filename.jpg">
        </label>
        <div class="progress" style="width:255px;">
            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100">0%</div>
        </div>
        <div class="alert" role="alert" style="width:255px;"></div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">图片地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="imageUrl" maxlength="255" lay-verify="required" readonly
               value="${(model.imageUrl)!""}" placeholder="请上传图片'" class="layui-input">
    </div>
</div>


<div class="layui-form-item">
    <label class="layui-form-label mylable">点击跳转地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="linkAddress" maxlength="255" lay-verify="required"
               value="${(model.linkAddress)!""}" placeholder="请填写路径, 例如：'/test/xxx'" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">图标题<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="title" maxlength="255" lay-verify="required"
               value="${(model.title)!""}" placeholder="请输入图标题" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">图片类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input id="tv" type="hidden" value="${(model.typeId)!""}">
        <select id="typeId" name="typeId" lay-verify="required" lay-search="">
            <option value=""></option>
        </select>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">排序<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="seriesNumber" maxlength="11" lay-verify="required"
               value="${(model.seriesNumber)!""}" placeholder="请输入序列号" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">背景色<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input id="paigusu" type="text" name="color" maxlength="255" lay-verify="required" readonly
               value="${(model.color)!""}" placeholder="请输入背景色" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label mylable">图片描述<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="describe" maxlength="600" lay-verify="required"
               value="${(model.describe)!""}" placeholder="请输入图片描述" class="layui-input">
    </div>
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
                    <img id="image" src="" >
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="crop">裁剪</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="/statics/plugins/paigusu/paigusu.min.js"></script>
<script type="text/javascript" src="/eduwebsiteimages/js/other.js"></script>
<script type="text/javascript" src="/statics/plugins/cropperjs/js/bootstrap/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="/statics/plugins/cropperjs/js/cropper/cropper.js"></script>
<script type="text/javascript" src="/eduwebsiteimages/js/cropper.my.js"></script>
