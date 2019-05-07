<#--  课程讲师关联公用页面-->
<#--  niushuai 2019-05-07 22:06:27-->
            <div class="layui-form-item">
            <label class="layui-form-label">课程id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="courseId" maxlength="11" lay-verify="required"
                 value="${(model.courseId)!""}"  placeholder="请输入课程id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">讲师id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="teacherId" maxlength="11" lay-verify="required"
                 value="${(model.teacherId)!""}"  placeholder="请输入讲师id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/educourseteacher/js/other.js"></script>
