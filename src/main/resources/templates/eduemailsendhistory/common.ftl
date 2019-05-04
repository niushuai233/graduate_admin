<#--  邮件发送记录公用页面-->
<#--  niushuai 2019-05-03 12:16:04-->
<div class="layui-form-item">
    <label class="layui-form-label">接收人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="email" maxlength="20" lay-verify="required"
               value="${(model.email)!""}" placeholder="请选择接收人" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label"><span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="userId" maxlength="11" lay-verify="required"
               value="${(model.userId)!""}" placeholder="请输入" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">邮件标题<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="title" maxlength="300" lay-verify="required"
               value="${(model.title)!""}" placeholder="请输入邮件标题" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">邮件正文<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="content" maxlength="20" lay-verify="required"
               value="${(model.content)!""}" placeholder="请输入邮件正文" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">发送时间<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="createTime" maxlength="20" lay-verify="required"
               value="${(model.createTime)!""}" placeholder="请输入" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">定时发送时间<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="sendTime" maxlength="20" lay-verify="required"
               value="${(model.sendTime)!""}" placeholder="请输入定时发送时间" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">1 普通 2 定时<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="type" maxlength="3" lay-verify="required"
               value="${(model.type)!""}" placeholder="请输入1 普通 2 定时" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">创建日期<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="createDate" maxlength="20" lay-verify="required"
               value="${(model.createDate)!""}" placeholder="请输入创建日期" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">更新日期<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="updateDate" maxlength="20" lay-verify="required"
               value="${(model.updateDate)!""}" placeholder="请输入更新日期" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">创建人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="createBy" maxlength="255" lay-verify="required"
               value="${(model.createBy)!""}" placeholder="请输入创建人" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">更新人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="updateBy" maxlength="255" lay-verify="required"
               value="${(model.updateBy)!""}" placeholder="请输入更新人" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
         value="${(model.state)!"1"}" class="layui-input-inline"></div>
</div>
<script type="text/javascript" src="/eduemailsendhistory/js/other.js"></script>
