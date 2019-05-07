<#--  推荐课程表公用页面-->
<#--  niushuai 2019-05-08 01:08:50-->
            <div class="layui-form-item">
            <label class="layui-form-label">主键<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="50" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入主键"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">推荐分类的id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="recommendId" maxlength="11" lay-verify="required"
                 value="${(model.recommendId)!""}"  placeholder="请输入推荐分类的id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">课程id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="courseId" maxlength="20" lay-verify="required"
                 value="${(model.courseId)!""}"  placeholder="请输入课程id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">课程显示排序<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="orderNum" maxlength="20" lay-verify="required"
                 value="${(model.orderNum)!""}"  placeholder="请输入课程显示排序"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">创建时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createTime" maxlength="20" lay-verify="required"
                 value="${(model.createTime)!""}"  placeholder="请输入创建时间"  class="layui-input">
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
            <label class="layui-form-label">创建人<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createBy" maxlength="50" lay-verify="required"
                 value="${(model.createBy)!""}"  placeholder="请输入创建人"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">更新人<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateBy" maxlength="50" lay-verify="required"
                 value="${(model.updateBy)!""}"  placeholder="请输入更新人"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/eduwebsitecoursedetail/js/other.js"></script>
