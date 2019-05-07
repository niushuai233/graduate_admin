<#--  niushuai 2019-05-08 01:59:37-->
<!DOCTYPE html>
<html>
<head>
    <title>课程评论列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/educomment/js/list.js"></script>
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
            <button class="layui-btn search-btn" table-id="eduCommentTable" lay-submit="" lay-filter="search">
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
    <#--<@shiro.hasPermission name="educomment:save">
        <button class="layui-btn" onclick="addPage('/educomment/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="educomment:update">
        <button class="layui-btn" onclick="editPage('eduCommentTable','/educomment/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
        <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','eduCommentTable','/educomment/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger"
                onclick="updateState('批量禁用','eduCommentTable','/educomment/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
    </@shiro.hasPermission>-->
    <@shiro.hasPermission name="educomment:delete">
        <button class="layui-btn layui-btn-delete"
                onclick="deleteBatch('批量删除','eduCommentTable','/educomment/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="eduCommentTable" cyType="pageGrid"
           cyProps="url:'/educomment/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="5%" param="{name:'commentId',isPrimary:'true',hide:'false'}">评论ID</th>

            <th width="5%" param="{name:'type', render: 'Render.type'}">分类</th>

            <th width="10%" param="{name:'createBy'}">发表用户</th>

            <th width="10%" param="{name:'fatherId'}">父级评论ID<br/>(为0是评论,其他为回复)</th>

            <th width="20%" param="{name:'content', render: 'Render.content'}">评论内容</th>

            <#--<th width="10%" param="{name:'otherId'}">评论的相关id</th>-->

            <th width="5%" param="{name:'praiseCount'}">点赞量</th>

            <th width="5%" param="{name:'replyCount'}">回复量</th>


            <!--isPrimary：渲染列-->
            <th width="10%" param="{operate:'true',buttons:'Render.info, Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>