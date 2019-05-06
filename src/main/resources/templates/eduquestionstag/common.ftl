<#--  问答标签公用页面-->
<#--  niushuai 2019-05-06 13:48:05-->


<div class="layui-form-item">
    <label class="layui-form-label">标签名<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="questionsTagName" maxlength="50" lay-verify="required"
               value="${(model.questionsTagName)!""}" placeholder="请输入标签名" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="status"
         value="${(model.status)!"1"}" class="layui-input-inline"></div>
</div>
<script type="text/javascript" src="/eduquestionstag/js/other.js"></script>
