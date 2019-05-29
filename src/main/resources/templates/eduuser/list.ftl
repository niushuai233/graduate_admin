<#--  niushuai 2019-03-13 20:58:42-->
<!DOCTYPE html>
<html>
<head>
    <title>学生信息表列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eduuser/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">学号或工号:</label>
        <div class="layui-input-inline">
            <input type="text" name="stuNoVague" placeholder="请输入学号或工号" class="layui-input">
        </div>
        <label class="layui-form-label">姓名:</label>
        <div class="layui-input-inline">
            <input type="text" name="userNameVague" placeholder="请输入姓名" class="layui-input">
        </div>
        <label class="layui-form-label">联系方式:</label>
        <div class="layui-input-inline">
            <input type="text" name="mobileVague" placeholder="请输入手机号" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="eduUserTable" lay-submit="" lay-filter="search">
                <i class="fa fa-search">&nbsp;</i>查询
            </button>
            <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
        </div>
    </div>
    <div class="layui-form-item more-search">
        <#-- 更多条件-->
        <label class="layui-form-label">邮箱:</label>
        <div class="layui-input-inline">
            <input type="text" name="emailVague" placeholder="请输入邮箱" class="layui-input">
        </div>
        <label class="layui-form-label">性别:</label>
        <div class="layui-input-inline">
            <select name="sex" lay-verify="sex2">
                <option value="">请选择</option>
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
        </div>
        <label class="layui-form-label">状态:</label>
        <div class="layui-input-inline">
            <select name="isAvalible" lay-verify="isAvalible">
                <option value="">请选择</option>
                <option value="1">启用</option>
                <option value="0">禁用</option>
            </select>
        </div>

    </div>
</form>
<div class="layui-btn-group">
    <@shiro.hasPermission name="eduuser:import">
        <div style="float: left;" cyType="fileUploadTool" cyProps="url:'/eduuser/userImport',value:'/statics/img/timg.jpg',name:'file',exts:'xlsx|xls',type:'file',btnName:'选择模板文件',multiple:'false'"></div>

        <button class="layui-btn layui-btn" onclick="templateDownload('/statics/excel/edu_user_template.xlsx');">
            模板下载
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduuser:save">
        <button class="layui-btn" onclick="addPage('/eduuser/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="eduuser:update">
        <button class="layui-btn" onclick="editPage('eduUserTable','/eduuser/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
        <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','eduUserTable','/eduuser/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','eduUserTable','/eduuser/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
        <button class="layui-btn" onclick="initPassword('eduUserTable','/eduuser/initPassword');"
                style="margin-left: 5px!important;">
            <i class="fa fa-refresh">&nbsp;</i>初始化密码 123456
        </button>
    </@shiro.hasPermission>

    <@shiro.hasPermission name="eduuser:delete">
        <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','eduUserTable','/eduuser/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>



</div>
<div class="layui-form ">
    <table class="layui-table" id="eduUserTable" cyType="pageGrid"
           cyProps="url:'/eduuser/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <th width="5%" param="{name:'userId',isPrimary:'true',hide:'false'}">id</th>
            <th width="10%" param="{name:'stuNo'}">学号</th>
            <th width="10%" param="{name:'userName'}">姓名</th>
            <th width="7%" param="{name:'mobile'}">手机号</th>
            <th width="10%" param="{name:'email'}">邮箱</th>
            <th width="5%" param="{name:'sex',render:'Render.sex'}">性别</th>
            <th width="5%" param="{name:'age'}">年龄</th>
            <th width="10%" param="{name:'createTime'}">创建时间</th>
            <th width="5%" param="{name:'isAvalible',enumName:'StateEnum',render:'Render.mmmState'}">状态</th>
            <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>
<script src="/eduuser/js/other.js"></script>