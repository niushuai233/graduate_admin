<#--  niushuai 2019-05-05 22:47:34-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eduwebsiteehcache/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">名称:</label>
        <div class="layui-input-inline">
            <input type="text" name="ehcacheKeyVague" placeholder="请输入名称" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="eduWebsiteEhcacheTable" lay-submit="" lay-filter="search">
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

    <@shiro.hasPermission name="eduwebsiteehcache:delete">
        <button class="layui-btn layui-btn-delete"
                onclick="deleteBatch('批量删除','eduWebsiteEhcacheTable','/eduwebsiteehcache/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="eduWebsiteEhcacheTable" cyType="pageGrid"
           cyProps="url:'/eduwebsiteehcache/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">主键</th>


            <th width="10%" param="{name:'ehcacheKey'}">Key</th>

            <th width="10%" param="{name:'ehcacheDesc'}">描述</th>
            <!--isPrimary：渲染列-->
            <th width="10%" param="{operate:'true',buttons:'Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>