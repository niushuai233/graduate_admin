<#--  问答评论公用页面-->
<#--  niushuai 2019-05-07 00:16:25-->
            <div class="layui-form-item">
            <label class="layui-form-label">主键id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="50" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入主键id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">评论人id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="cusId" maxlength="50" lay-verify="required"
                 value="${(model.cusId)!""}"  placeholder="请输入评论人id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">评论人昵称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="cusName" maxlength="255" lay-verify="required"
                 value="${(model.cusName)!""}"  placeholder="请输入评论人昵称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">问答id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="questionId" maxlength="50" lay-verify="required"
                 value="${(model.questionId)!""}"  placeholder="请输入问答id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">评论内容<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="content" maxlength="20" lay-verify="required"
                 value="${(model.content)!""}"  placeholder="请输入评论内容"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">是否最佳答案 0否1是<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="isBest" maxlength="1" lay-verify="required"
                 value="${(model.isBest)!""}"  placeholder="请输入是否最佳答案 0否1是"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">回复数量<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="replyCount" maxlength="11" lay-verify="required"
                 value="${(model.replyCount)!""}"  placeholder="请输入回复数量"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">点赞数<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="praiseCount" maxlength="11" lay-verify="required"
                 value="${(model.praiseCount)!""}"  placeholder="请输入点赞数"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">回复时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="addTime" maxlength="20" lay-verify="required"
                 value="${(model.addTime)!""}"  placeholder="请输入回复时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">父级评论id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="commentId" maxlength="50" lay-verify="required"
                 value="${(model.commentId)!""}"  placeholder="请输入父级评论id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">0禁用 1启用<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="state" maxlength="255" lay-verify="required"
                 value="${(model.state)!""}"  placeholder="请输入0禁用 1启用"  class="layui-input">
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
    <script type="text/javascript" src="/eduquestionscomment/js/other.js"></script>
