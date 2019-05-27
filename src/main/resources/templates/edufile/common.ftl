<#--  公用页面-->
<#--  niushuai 2019-05-23 12:14:26-->
            <#--<div class="layui-form-item">
                <label class="layui-form-label"><span class="span_must">*</span></label>
                <div class="layui-input-normal">
                    <input type="text" name="id" maxlength="11" lay-verify="required"
                           value="${(model.id)!""}" placeholder="请输入" class="layui-input">
                </div>
            </div>-->

              <div class="layui-form-item">
                  <label class="layui-form-label">文件名<span class="span_must">*</span></label>
                  <div class="layui-input-normal">
                      <input type="text" name="name" maxlength="255" lay-verify="required"
                             value="${(model.name)!""}" placeholder="请输入" class="layui-input">
                  </div>
              </div>

              <#--<div class="layui-form-item">
                  <label class="layui-form-label">文件路径<span class="span_must">*</span></label>
                  <div class="layui-input-normal">
                      <input type="text" name="url" maxlength="255" lay-verify="required"
                             value="${(model.url)!""}" placeholder="请输入" class="layui-input">
                  </div>
              </div>-->

              <#--<div class="layui-form-item">
                  <label class="layui-form-label">选择课程<span class="span_must">*</span></label>
                  <div class="layui-input-normal">
                      <input type="text" name="courseid" maxlength="20" lay-verify="required"
                             value="${(model.courseid)!""}" placeholder="请输入" class="layui-input">
                  </div>
              </div>-->

                <div class="layui-form-item">
                    <label class="layui-form-label">选择课程<span class="span_must">*</span></label>
                    <div class="layui-input-normal">
                        <div cyType="selectTool" cyProps="url:'/educourse/findAllCourseSelectTool',multiple:'false', filter:'courseIdTool'"
                             value="${(model.courseid)!""}" name="courseid" class="layui-input-normal"></div>
                    </div>
                </div>

                <div class="layui-form-item" id="videoDiv">
                    <label class="layui-form-label">文件地址<span class="span_must">*</span></label>
                    <div style="float: left;" cyType="fileUploadTool" cyProps="url:'/upload/fileUpload',value:'/statics/img/timg.jpg',name:'file',exts:'xlsx|docx|pptx|zip|rar|xls|doc|ppt|pdf|txt',type:'video',btnName:'选择文件',multiple:'false'"></div>
                    <div class="layui-input-normal" style="margin-left: 0px;">
                        <input type="text" id="videoUrl" name="url" maxlength="500" readonly style="margin-top: 50px;margin-left: -110px;"
                               value="${(model.url)!""}" id="url" placeholder="请上传文件获取地址" class="layui-input">
                    </div>

                </div>


    <script type="text/javascript" src="/edufile/js/other.js"></script>
