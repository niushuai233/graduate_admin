<#--  文章内容表公用页面-->
<#--  niushuai 2019-05-07 01:07:31-->
            <div class="layui-form-item">
            <label class="layui-form-label">文章ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="articleId" maxlength="11" lay-verify="required"
                 value="${(model.articleId)!""}"  placeholder="请输入文章ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">文章内容<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="content" maxlength="20" lay-verify="required"
                 value="${(model.content)!""}"  placeholder="请输入文章内容"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/eduarticlecontent/js/other.js"></script>
