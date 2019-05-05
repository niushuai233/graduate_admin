<#--  公用页面-->
<#--  niushuai 2019-05-05 22:47:34-->
            <div class="layui-form-item">
            <label class="layui-form-label">主键<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="11" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入主键"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">ehcache key<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="ehcacheKey" maxlength="200" lay-verify="required"
                 value="${(model.ehcacheKey)!""}"  placeholder="请输入ehcache key"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">描述<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="ehcacheDesc" maxlength="200" lay-verify="required"
                 value="${(model.ehcacheDesc)!""}"  placeholder="请输入描述"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>
    <script type="text/javascript" src="/eduwebsiteehcache/js/other.js"></script>
