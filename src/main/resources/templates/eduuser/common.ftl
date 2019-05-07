<#--  学生信息表公用页面-->
<#--  niushuai 2019-03-13 20:58:42-->


<div class="layui-form-item">
    <label class="layui-form-label">学号<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="stuNo" maxlength="255" lay-verify="required"
               value="${(model.stuNo)!""}" placeholder="请输入学号" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">用户名<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="userName" maxlength="255" lay-verify="required"
               value="${(model.userName)!""}" placeholder="请输入用户名" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">性别<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div class="layui-input-inline">
            <select id="sexSelect" name="sex" lay-verify="required">
                <option value="">请选择</option>
                <option value="1" checked="checked">男</option>
                <option value="2" checked="checked">女</option>
            </select>
        </div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">年龄</label>
    <div class="layui-input-normal">
        <input type="text" name="age" maxlength="3"
               value="${(model.age)!""}" placeholder="请输入年龄" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">手机号<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="mobile" maxlength="11" lay-verify="required"
               value="${(model.mobile)!""}" placeholder="请输入手机号" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">邮箱号</label>
    <div class="layui-input-normal">
        <input type="text" name="email" maxlength="255"
               value="${(model.email)!""}" placeholder="请输入邮箱号" class="layui-input">
    </div>
</div>

<script>
    var sexValue = '${model.sex}';
    if (!isEmpty(sexValue)) {
        $("#sexSelect").find('option[value="' + sexValue + '"]').prop("selected", true);
        layui.form.render();
    }
</script>
