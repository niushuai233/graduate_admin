<#--  niushuai 2019-05-03 12:16:04-->
<!DOCTYPE html>
<html>
<head>
    <title>邮件发送记录列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eduemailsendhistory/js/list.js"></script>
</head>
<body>
<form class="layui-form " action="">
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱:</label>
        <div class="layui-input-inline">
            <input type="text" name="emailVague" placeholder="请输入邮箱" class="layui-input">
        </div>

        <div class="layui-input-normal">
            <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                <i class="fa fa-chevron-down">&nbsp;</i>更多
            </button>
            <button class="layui-btn search-btn" table-id="eduEmailsendHistoryTable" lay-submit="" lay-filter="search">
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


</div>
<div class="layui-form ">
    <table class="layui-table" id="eduEmailsendHistoryTable" cyType="pageGrid"
           cyProps="url:'/eduemailsendhistory/listData',checkbox:'false',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="0%" param="{type:'checkbox', hide:'true'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>


            <th width="10%" param="{name:'email'}">接收人邮箱</th>

            <th width="15%" param="{name:'title'}">标题</th>

            <th width="10%" param="{name:'content', render:'Render.content'}">正文</th>

            <th width="5%" param="{name:'status'}">状态</th>

            <th width="5%" param="{name:'type'}">类型</th>

            <th width="10%" param="{name:'sendTime'}">发送时间</th>

            <th width="10%" param="{name:'createBy'}">创建人</th>

            <th width="10%" param="{name:'createDate'}">创建日期</th>

            <!--isPrimary：渲染列-->
            <th width="10%" param="{name:'status',enumName:'StateEnum',render:'Render.customState'}">状态</th>
            <th width="10%" param="{operate:'true',buttons:'Render.info,Render.state'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>