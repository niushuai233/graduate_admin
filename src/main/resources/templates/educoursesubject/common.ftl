<#--  公用页面-->
<#--  niushuai 2019-05-07 22:08:20-->
            <div class="layui-form-item">
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="10" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">课程id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="courseId" maxlength="11" lay-verify="required"
                 value="${(model.courseId)!""}"  placeholder="请输入课程id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">分类id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="subjectId" maxlength="11" lay-verify="required"
                 value="${(model.subjectId)!""}"  placeholder="请输入分类id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/educoursesubject/js/other.js"></script>
