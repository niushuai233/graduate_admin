<#--  niushuai 2019-05-07 13:44:30-->
<!DOCTYPE html>
<html>
<head>
    <title>课程表列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/educourse/js/list.js"></script>
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
            <button class="layui-btn search-btn" table-id="eduCourseTable" lay-submit="" lay-filter="search">
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
    <@shiro.hasPermission name="educourse:save">
        <button class="layui-btn" onclick="addPage('/educourse/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="educourse:update">
        <button class="layui-btn" onclick="editPage('eduCourseTable','/educourse/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
        <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','eduCourseTable','/educourse/enable')">
            <i class="fa fa-check-square-o">&nbsp;</i>启用
        </button>
        <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','eduCourseTable','/educourse/disable')">
            <i class="fa fa-expeditedssl">&nbsp;</i>禁用
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="educourse:delete">
        <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','eduCourseTable','/educourse/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <input type="hidden" id="courseAccessPath" value="${(courseAccessPath)!""}"/>
    <table class="layui-table" id="eduCourseTable" cyType="pageGrid"
           cyProps="url:'/educourse/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="1%" param="{name:'courseId',isPrimary:'true',hide:'true'}">课程编号</th>

            <th width="10%" param="{name:'courseName'}">课程名称</th>

            <th width="10%" param="{name:'logo', render:'Render.pic'}">课程封面</th>

            <th width="10%" param="{name:'subjectLink'}">所属专业</th>

            <th width="5%" param="{name:'pageViewcount'}">浏览量</th>

            <th width="5%" param="{name:'sequence'}">排序</th>

            <th width="5%" param="{name:'createBy'}">创建人</th>

            <th width="7%" param="{name:'addTime'}">创建时间</th>

            <th width="5%" param="{name:'updateBy'}">更新人</th>

            <th width="7%" param="{name:'updateTime'}">更新时间</th>
            <!--isPrimary：渲染列-->
            <th width="5%" param="{name:'isAvaliable',enumName:'CourseEnum',render:'Render.customState'}">状态</th>
            <th width="15%" param="{operate:'true',buttons:'Render.visit,Render.state,Render.edit,Render.delete'}">操作
            </th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>