<#--  Cron任务公用页面-->
<#--  niushuai 2019-05-05 10:06:03-->
            <div class="layui-form-item">
            <label class="layui-form-label">id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="255" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">任务名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="jobName" maxlength="255" lay-verify="required"
                 value="${(model.jobName)!""}"  placeholder="请输入任务名称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">cron表达式<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="cron" maxlength="255" lay-verify="required"
                 value="${(model.cron)!""}"  placeholder="请输入cron表达式"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">是否启动 0 未启动 1 已启动<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="started" maxlength="1" lay-verify="required"
                 value="${(model.started)!""}"  placeholder="请输入是否启动 0 未启动 1 已启动"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">是否需要重复执行<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="recycle" maxlength="1" lay-verify="required"
                 value="${(model.recycle)!""}"  placeholder="请输入是否需要重复执行"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">执行路径<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="clazzPath" maxlength="255" lay-verify="required"
                 value="${(model.clazzPath)!""}"  placeholder="请输入执行路径"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">任务描述<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="jobDesc" maxlength="255" lay-verify="required"
                 value="${(model.jobDesc)!""}"  placeholder="请输入任务描述"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">删除标志 0已删除 1未删除<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="state" maxlength="1" lay-verify="required"
                 value="${(model.state)!""}"  placeholder="请输入删除标志 0已删除 1未删除"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">创建日期<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createDate" maxlength="20" lay-verify="required"
                 value="${(model.createDate)!""}"  placeholder="请输入创建日期"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">更新日期<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateDate" maxlength="20" lay-verify="required"
                 value="${(model.updateDate)!""}"  placeholder="请输入更新日期"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">创建人<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createBy" maxlength="255" lay-verify="required"
                 value="${(model.createBy)!""}"  placeholder="请输入创建人"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">更新人<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateBy" maxlength="255" lay-verify="required"
                 value="${(model.updateBy)!""}"  placeholder="请输入更新人"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/sysjob/js/other.js"></script>
