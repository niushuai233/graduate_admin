<#--  专业信息公用页面-->
<#--  niushuai 2019-05-06 12:46:32-->
<div class="layui-form-item">
    <label class="layui-form-label">专业名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="subjectName" maxlength="50" lay-verify="required"
               value="${(model.subjectName)!""}" placeholder="请输入专业名称" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">上级菜单<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input value="${(model.parentId)!""}" id="parentId" cyType="treeTool" lay-verify="required"
               cyProps="url:'/syssubject/selectTreeTool',name:'parentId'"
               placeholder="请选择上级菜单" class="layui-input"/>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">排序<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="sort" maxlength="20" lay-verify="required"
               value="${(model.sort)!""}" placeholder="请输入排序" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="status"
         value="${(model.status)!"1"}" class="layui-input-inline"></div>
</div>
<script type="text/javascript" src="/syssubject/js/other.js"></script>
