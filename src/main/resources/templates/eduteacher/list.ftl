<#--  niushuai 2019-05-05 23:22:24-->
<!DOCTYPE html>
<html>
<head>
    <title>讲师列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eduteacher/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>
        <div class="layui-input-inline">
            <input type="text" name="nameVague" placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="eduTeacherTable" lay-submit="" lay-filter="search">
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
    <@shiro.hasPermission name="eduteacher:save">
        <button class="layui-btn" onclick="addPage('/eduteacher/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduteacher:update">
        <button class="layui-btn" onclick="editPage('eduTeacherTable','/eduteacher/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
        <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','eduTeacherTable','/eduteacher/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger"
                onclick="updateState('批量禁用','eduTeacherTable','/eduteacher/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduteacher:delete">
        <button class="layui-btn layui-btn-delete"
                onclick="deleteBatch('批量删除','eduTeacherTable','/eduteacher/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="eduTeacherTable" cyType="pageGrid"
           cyProps="url:'/eduteacher/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="0%" param="{name:'id',isPrimary:'true',hide:'true'}">教师ID</th>

            <th width="7%" param="{name:'name'}">教师姓名</th>

            <th width="8%" param="{name:'picPath', render:'Render.picImg'}">头像</th>

            <th width="12%" param="{name:'education'}">资历</th>

            <th width="11%" param="{name:'career',render:'Render.career'}">简介</th>

            <th width="5%" param="{name:'isStar', render: 'Render.isStar'}">头衔</th>

            <th width="5%" param="{name:'createBy'}">创建人</th>
            <th width="7%" param="{name:'createTime'}">创建时间</th>
            <th width="5%" param="{name:'updateBy'}">更新人</th>
            <th width="7%" param="{name:'updateTime'}">更新时间</th>

            <th width="3%" param="{name:'sort'}">排序</th>


            <!--isPrimary：渲染列-->
            <th width="4%" param="{name:'status',enumName:'StateEnum',render:'Render.customState'}">状态</th>
            <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>