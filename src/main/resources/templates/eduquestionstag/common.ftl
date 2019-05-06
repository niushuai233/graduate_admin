<#--  问答标签公用页面-->
<#--  niushuai 2019-05-06 13:48:05-->
            <div class="layui-form-item">
            <label class="layui-form-label">主键id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="questionsTagId" maxlength="30" lay-verify="required"
                 value="${(model.questionsTagId)!""}"  placeholder="请输入主键id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">标签名<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="questionsTagName" maxlength="50" lay-verify="required"
                 value="${(model.questionsTagName)!""}"  placeholder="请输入标签名"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">父级id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="parentId" maxlength="50" lay-verify="required"
                 value="${(model.parentId)!""}"  placeholder="请输入父级id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">父级标签名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="parentName" maxlength="50" lay-verify="required"
                 value="${(model.parentName)!""}"  placeholder="请输入父级标签名称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态0默认1删除<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="status" maxlength="1" lay-verify="required"
                 value="${(model.status)!""}"  placeholder="请输入状态0默认1删除"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">标签创建时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createTime" maxlength="20" lay-verify="required"
                 value="${(model.createTime)!""}"  placeholder="请输入标签创建时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">更新时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateTime" maxlength="20" lay-verify="required"
                 value="${(model.updateTime)!""}"  placeholder="请输入更新时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createBy" maxlength="50" lay-verify="required"
                 value="${(model.createBy)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateBy" maxlength="50" lay-verify="required"
                 value="${(model.updateBy)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/eduquestionstag/js/other.js"></script>
