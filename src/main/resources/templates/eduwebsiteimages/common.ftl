<#--  banner图管理公用页面-->
<#--  niushuai 2019-03-19 16:36:50-->

<div class="layui-form-item">
    <label class="layui-form-label">上传图片<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <img src="${(model.imageUrl)!""}" style="width: 355px; height: 255px;"/>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">图链接地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="linkAddress" maxlength="255" lay-verify="required" readonly
               value="${(model.linkAddress)!""}" placeholder="请上传图片" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">图标题<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="title" maxlength="255" lay-verify="required"
               value="${(model.title)!""}" placeholder="请输入图标题" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">图片类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input id="tv" type="hidden" value="${(model.typeId)!""}">
        <select id="typeId" name="typeId" lay-verify="required" lay-search="">
            <option value=""></option>
        </select>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">排序<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="seriesNumber" maxlength="11" lay-verify="required"
               value="${(model.seriesNumber)!""}" placeholder="请输入序列号" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">背景色<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input id="paigusu" type="text" name="color" maxlength="255" lay-verify="required"
               value="${(model.color)!""}" placeholder="请输入背景色" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">图片描述<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="describe" maxlength="600" lay-verify="required"
               value="${(model.describe)!""}" placeholder="请输入图片描述" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
         value="${(model.state)!"1"}" class="layui-input-inline"></div>
</div>
<script type="text/javascript" src="/statics/plugins/paigusu/paigusu.min.js"></script>
<script type="text/javascript" src="/eduwebsiteimages/js/other.js"></script>
