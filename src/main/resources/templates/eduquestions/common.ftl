<#--  问答公用页面-->
<#--  niushuai 2019-05-06 21:39:25-->
<link rel="stylesheet" type="text/css" href="/statics/plugins/editor.md/css/editormd.css">

<div class="layui-form-item">
    <label class="layui-form-label">问答标题<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="title" maxlength="100" lay-verify="required"
               value="${(model.title)!""}" placeholder="请输入问答标题" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">分类<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 150px;">
        <div cyType="selectTool" cyProps="codeName:'questionType',search:'true',filter:'type'"
             name="type" value="${(model.type)!"1"}" class="layui-input-inline"></div>
    </div>
    <label class="layui-form-label">是否可回复<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 150px;">
        <div cyType="selectTool" cyProps="codeName:'canReply',search:'true',filter:'status'"
             name="status" value="${(model.status)!"0"}" class="layui-input-inline"></div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">回复量<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 150px;">
        <input type="number" name="replyCount" maxlength="255" lay-verify="required"
               value="${(model.replyCount)!"0"}" placeholder="请输入问答回复数量" class="layui-input">
    </div>

    <label class="layui-form-label">浏览量<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 150px;">
        <input type="number" name="browseCount" maxlength="255" lay-verify="required"
               value="${(model.browseCount)!"0"}" placeholder="请输入问答浏览数量" class="layui-input">
    </div>

    <label class="layui-form-label">点赞量<span class="span_must">*</span></label>
    <div class="layui-input-normal" style="width: 150px;">
        <input type="number" name="praiseCount" maxlength="255" lay-verify="required"
               value="${(model.praiseCount)!"0"}" placeholder="请输入问答点赞数量" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label"><内></内>容<span class="span_must">*</span></label>
    <textarea id="md" style="display: none;">${(model.markdown)!""}</textarea>
    <div id="editormdDiv">
        <textarea style="display:none;" name="markdown" class="editormd-markdown-textarea"></textarea>
        <textarea style="display:none;" name="html" class="editormd-html-textarea"></textarea>

    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
         value="${(model.state)!"1"}" class="layui-input-inline"></div>
</div>

<script type="text/javascript" src="/statics/plugins/editor.md/editormd.js"></script>
<script type="text/javascript" src="/statics/plugins/editor.md/initEditor.js"></script>
<script type="text/javascript" src="/eduquestions/js/other.js"></script>
