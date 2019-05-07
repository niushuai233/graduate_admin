<#--  课程评论公用页面-->
<#--  niushuai 2019-05-08 01:59:37-->
            <div class="layui-form-item">
            <label class="layui-form-label">评论表<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="commentId" maxlength="50" lay-verify="required"
                 value="${(model.commentId)!""}"  placeholder="请输入评论表"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">用户id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="userId" maxlength="50" lay-verify="required"
                 value="${(model.userId)!""}"  placeholder="请输入用户id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">父级评论id(为0则是一级评论,不为0则是回复)<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="pCommentId" maxlength="50" lay-verify="required"
                 value="${(model.pCommentId)!""}"  placeholder="请输入父级评论id(为0则是一级评论,不为0则是回复)"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">评论内容<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="content" maxlength="1000" lay-verify="required"
                 value="${(model.content)!""}"  placeholder="请输入评论内容"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">创建时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="addtime" maxlength="20" lay-verify="required"
                 value="${(model.addtime)!""}"  placeholder="请输入创建时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">评论的相关id<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="otherId" maxlength="50" lay-verify="required"
                 value="${(model.otherId)!""}"  placeholder="请输入评论的相关id"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">点赞数量<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="praiseCount" maxlength="20" lay-verify="required"
                 value="${(model.praiseCount)!""}"  placeholder="请输入点赞数量"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">回复数量<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="replyCount" maxlength="20" lay-verify="required"
                 value="${(model.replyCount)!""}"  placeholder="请输入回复数量"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">1文章 2课程<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="type" maxlength="1" lay-verify="required"
                 value="${(model.type)!""}"  placeholder="请输入1文章 2课程"  class="layui-input">
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
    <script type="text/javascript" src="/educomment/js/other.js"></script>
