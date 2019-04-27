<#--  图片类型表公用页面-->
<#--  niushuai 2019-03-19 16:36:50-->

<div class="layui-form-item">
    <label class="layui-form-label">类型名<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="typeName" maxlength="50" lay-verify="required"
               value="${(model.typeName)!""}" placeholder="请输入类型名" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
         value="${(model.state)!"1"}" class="layui-input-inline"></div>
</div>