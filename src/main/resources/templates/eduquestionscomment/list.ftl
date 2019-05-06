<#--  niushuai 2019-05-07 00:16:25-->
<!DOCTYPE html>
<html>
<head>
    <title>问答评论列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eduquestionscomment/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>
        <div class="layui-input-inline">
            <input type="text" name="" placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="eduQuestionsCommentTable" lay-submit="" lay-filter="search">
                <i class="fa fa-search">&nbsp;</i>查询
            </button>
            <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
        </div>
    </div>
    <div class="layui-form-item more-search">
        <#-- 更多条件-->
    </div>
</form>
<div class="layui-btn-group">
    <@shiro.hasPermission name="eduquestionscomment:save">
        <#--<button class="layui-btn" onclick="addPage('/eduquestionscomment/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>-->
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduquestionscomment:update">
        <#--<button class="layui-btn" onclick="editPage('eduQuestionsCommentTable','/eduquestionscomment/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>-->
        <button class="layui-btn layui-btn-green"
                onclick="updateState('批量启用','eduQuestionsCommentTable','/eduquestionscomment/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger"
                onclick="updateState('批量禁用','eduQuestionsCommentTable','/eduquestionscomment/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduquestionscomment:delete">
        <button class="layui-btn layui-btn-delete"
                onclick="deleteBatch('批量删除','eduQuestionsCommentTable','/eduquestionscomment/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <input type="hidden" id="questionInfoPath" value="${(questionInfoPath)!""}"/>

    <table class="layui-table" id="eduQuestionsCommentTable" cyType="pageGrid"
           cyProps="url:'/eduquestionscomment/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="1%" param="{name:'id',isPrimary:'true',hide:'true'}">主键id</th>

            <th width="10%" param="{name:'cusId'}">评论人id</th>

            <th width="10%" param="{name:'cusName'}">评论人昵称</th>

            <th width="10%" param="{name:'content', render:'Render.content'}">评论内容</th>

            <#--<th width="5%" param="{name:'isBest', render:'Render.isBest'}">最佳答案</th>-->

            <th width="5%" param="{name:'replyCount'}">回复量</th>

            <th width="5%" param="{name:'praiseCount'}">点赞数</th>

            <th width="7%" param="{name:'addTime'}">回复时间</th>

            <#--<th width="10%" param="{name:'commentId'}">父级评论id</th>-->

            <th width="7%" param="{name:'updateTime'}">更新时间</th>

            <th width="5%" param="{name:'updateBy'}">更新人</th>

            <!--isPrimary：渲染列-->
            <th width="5%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>

            <th width="10%" param="{operate:'true',buttons:'Render.visit, Render.state,Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>