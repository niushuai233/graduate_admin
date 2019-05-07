<#--  niushuai 2019-05-05 10:06:03-->
<!DOCTYPE html>
<html>
<head>
    <title>Cron任务列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/sysjob/js/list.js"></script>
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
            <button class="layui-btn search-btn" table-id="sysJobTable" lay-submit="" lay-filter="search">
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
    <@shiro.hasPermission name="sysjob:save">
        <button class="layui-btn" onclick="addPage('/sysjob/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="sysjob:update">
        <button class="layui-btn" onclick="editPage('sysJobTable','/sysjob/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
        <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','sysJobTable','/sysjob/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','sysJobTable','/sysjob/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="sysjob:delete">
        <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','sysJobTable','/sysjob/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="sysJobTable" cyType="pageGrid"
           cyProps="url:'/sysjob/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">id</th>


            <th width="10%" param="{name:'jobName'}">任务名称</th>

            <th width="10%" param="{name:'cron'}">cron表达式</th>

            <th width="10%" param="{name:'started'}">是否启动 0 未启动 1 已启动</th>

            <th width="10%" param="{name:'recycle'}">是否需要重复执行</th>

            <th width="10%" param="{name:'clazzPath'}">执行路径</th>

            <th width="10%" param="{name:'jobDesc'}">任务描述</th>

            <th width="10%" param="{name:'state'}">删除标志 0已删除 1未删除</th>

            <th width="10%" param="{name:'createDate'}">创建日期</th>

            <th width="10%" param="{name:'updateDate'}">更新日期</th>

            <th width="10%" param="{name:'createBy'}">创建人</th>

            <th width="10%" param="{name:'updateBy'}">更新人</th>
            <!--isPrimary：渲染列-->
            <th width="10%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>
            <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>