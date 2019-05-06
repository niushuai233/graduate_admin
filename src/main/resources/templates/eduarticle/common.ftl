<#--  文章信息表公用页面-->
<#--  niushuai 2019-05-07 01:07:31-->
            <div class="layui-form-item">
            <label class="layui-form-label">文章ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="articleId" maxlength="11" lay-verify="required"
                 value="${(model.articleId)!""}"  placeholder="请输入文章ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章标题<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="title" maxlength="100" lay-verify="required"
                 value="${(model.title)!""}"  placeholder="请输入文章标题"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章摘要<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="summary" maxlength="200" lay-verify="required"
                 value="${(model.summary)!""}"  placeholder="请输入文章摘要"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章关键字<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="keyWord" maxlength="50" lay-verify="required"
                 value="${(model.keyWord)!""}"  placeholder="请输入文章关键字"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章图片URL<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="imageUrl" maxlength="100" lay-verify="required"
                 value="${(model.imageUrl)!""}"  placeholder="请输入文章图片URL"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章来源<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="source" maxlength="50" lay-verify="required"
                 value="${(model.source)!""}"  placeholder="请输入文章来源"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章作者<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="author" maxlength="10" lay-verify="required"
                 value="${(model.author)!""}"  placeholder="请输入文章作者"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章发布时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="publishTime" maxlength="20" lay-verify="required"
                 value="${(model.publishTime)!""}"  placeholder="请输入文章发布时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章访问链接<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="link" maxlength="100" lay-verify="required"
                 value="${(model.link)!""}"  placeholder="请输入文章访问链接"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章类型 2文章<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="articleType" maxlength="4" lay-verify="required"
                 value="${(model.articleType)!""}"  placeholder="请输入文章类型 2文章"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章点击量<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="clickNum" maxlength="11" lay-verify="required"
                 value="${(model.clickNum)!""}"  placeholder="请输入文章点击量"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">点赞数量<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="praiseCount" maxlength="11" lay-verify="required"
                 value="${(model.praiseCount)!""}"  placeholder="请输入点赞数量"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">评论数<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="commentNum" maxlength="11" lay-verify="required"
                 value="${(model.commentNum)!""}"  placeholder="请输入评论数"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">排序值<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="sort" maxlength="11" lay-verify="required"
                 value="${(model.sort)!""}"  placeholder="请输入排序值"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">0禁用 1启用<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="state" maxlength="1" lay-verify="required"
                 value="${(model.state)!""}"  placeholder="请输入0禁用 1启用"  class="layui-input">
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
            <label class="layui-form-label">文章创建时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createTime" maxlength="20" lay-verify="required"
                 value="${(model.createTime)!""}"  placeholder="请输入文章创建时间"  class="layui-input">
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
            <label class="layui-form-label">更新时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateDate" maxlength="20" lay-verify="required"
                 value="${(model.updateDate)!""}"  placeholder="请输入更新时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/eduarticle/js/other.js"></script>
