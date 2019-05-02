<#--  导航表公用页面-->
<#--  niushuai 2019-05-02 17:16:49-->

<div class="layui-form-item">
    <label class="layui-form-label">名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="name" maxlength="100" lay-verify="required"
               value="${(model.name)!""}" placeholder="请输入导航显示名称" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">链接<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="url" maxlength="100" lay-verify="required"
               value="${(model.url)!""}" placeholder="请输入导航显示位置" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">新页面<span class="span_must">*</span></label>
    <div cyType="selectTool" cyProps="enumName:'YesOrNotEnum',search:'true',filter:'demo'"
         name="newpage" value="${(model.newpage)!""}" class="layui-input-inline"></div>  <br><br>

</div>

<div class="layui-form-item">
    <label class="layui-form-label">类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="enumName:'NavigateTypeEnum',search:'true',filter:'demo'"
             name="type" value="${(model.type)!""}" class="layui-input-inline"></div>  <br><br>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">显示排序<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="ordernum" lay-verify="required"
               value="${(model.ordernum)!""}" placeholder="请输入显示排序" class="layui-input" maxlength="2"/>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="status"
         value="${(model.status)!"1"}" class="layui-input-inline"></div>
</div>
<script type="text/javascript" src="/eduwebsitenavigate/js/other.js"></script>
