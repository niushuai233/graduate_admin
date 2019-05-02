<#--  niushuai 2019-04-29 12:58:02-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eduwebsiteprofile/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>
        <div class="layui-input-inline">
            <input type="text" name=""  placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="eduWebsiteProfileTable" lay-submit="" lay-filter="search">
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
        <@shiro.hasPermission name="eduwebsiteprofile:save">
        <button class="layui-btn" onclick="addPage('/eduwebsiteprofile/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="eduwebsiteprofile:update">
        <button class="layui-btn" onclick="editPage('eduWebsiteProfileTable','/eduwebsiteprofile/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
         <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','eduWebsiteProfileTable','/eduwebsiteprofile/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','eduWebsiteProfileTable','/eduwebsiteprofile/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="eduwebsiteprofile:delete">
         <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','eduWebsiteProfileTable','/eduwebsiteprofile/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
        </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="eduWebsiteProfileTable" cyType="pageGrid"
           cyProps="url:'/eduwebsiteprofile/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            			            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>
            
		                			
		          <th width="10%" param="{name:'type'}1">类型</th>
			            			
		          <th width="10%" param="{name:'desciption'}">内容JSON格式</th>
			            			
		          <th width="10%" param="{name:'explain'}">说明</th>

		          <th width="10%" param="{name:'createBy'}">创建人</th>
			            			
		          <th width="10%" param="{name:'createDate'}">创建时间</th>
			            			
		          <th width="10%" param="{name:'updateBy'}">更新人</th>
			            			
		          <th width="10%" param="{name:'updateDate'}">更新时间</th>
			                        <!--isPrimary：渲染列-->
            <th width="10%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>
            <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>