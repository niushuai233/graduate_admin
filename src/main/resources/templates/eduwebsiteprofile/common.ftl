<#--  公用页面-->
<#--  niushuai 2019-04-29 12:58:02-->
<div class="layui-form-item">
    <label class="layui-form-label"><span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="id" maxlength="10" lay-verify="required"
               value="${(model.id)!""}" placeholder="请输入" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="type" maxlength="20" lay-verify="required"
               value="${(model.type)!""}" placeholder="请输入类型" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">内容<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="desciption" maxlength="20" lay-verify="required"
               value="${(model.desciption)!""}" placeholder="请输入内容" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">说明<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="explain" maxlength="50" lay-verify="required"
               value="${(model.explain)!""}" placeholder="请输入说明" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
         value="${(model.state)!"1"}" class="layui-input-inline"></div>
</div>
<script type="text/javascript" src="/eduwebsiteprofile/js/other.js"></script>
