<#--  niushuai 2019-03-19 16:36:50-->
<!DOCTYPE html>
<html>
<head>
    <title>banner图管理列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eduwebsiteimages/js/list.js"></script>
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
            <button class="layui-btn search-btn" table-id="eduWebsiteImagesTable" lay-submit="" lay-filter="search">
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
    <@shiro.hasPermission name="eduwebsiteimages:save">
        <button class="layui-btn" onclick="addPage('/eduwebsiteimages/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduwebsiteimages:update">
        <button class="layui-btn" onclick="editPage('eduWebsiteImagesTable','/eduwebsiteimages/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
        <button class="layui-btn layui-btn-green"
                onclick="updateState('批量启用','eduWebsiteImagesTable','/eduwebsiteimages/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger"
                onclick="updateState('批量禁用','eduWebsiteImagesTable','/eduwebsiteimages/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduwebsiteimages:delete">
        <button class="layui-btn layui-btn-delete"
                onclick="deleteBatch('批量删除','eduWebsiteImagesTable','/eduwebsiteimages/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="eduWebsiteImagesTable" cyType="pageGrid"
           cyProps="url:'/eduwebsiteimages/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'imageId',isPrimary:'true',hide:'true'}"></th>

            <th width="10%" param="{name:'imageUrl',render:'Render.img'}">图片</th>

            <th width="10%" param="{name:'linkAddress'}">图链接地址</th>

            <th width="10%" param="{name:'title'}">图标题</th>

            <th width="5%" param="{name:'typeId'}">图片类型</th>

            <th width="3%" param="{name:'seriesNumber'}">排序</th>

            <th width="5%" param="{name:'color'}">背景色</th>

            <th width="10%" param="{name:'describe'}">图片描述</th>

            <th width="10%" param="{name:'createTime'}">创建时间</th>

            <th width="5%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>
            <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>