<#--  niushuai 2019-05-08 02:51:58-->
<!DOCTYPE html>
<html>
<head>
    <title>章节管理列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/educoursekpoint/js/list.js"></script>
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
            <button class="layui-btn search-btn" table-id="eduCourseKpointTable" lay-submit="" lay-filter="search">
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
    <@shiro.hasPermission name="educoursekpoint:save">
        <button class="layui-btn" onclick="addPage('/educoursekpoint/add')">
            <i class="fa fa-plus">&nbsp;</i>增加
        </button>
    </@shiro.hasPermission>
    <@shiro.hasPermission name="educoursekpoint:update">
        <button class="layui-btn" onclick="editPage('eduCourseKpointTable','/educoursekpoint/edit')">
            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
        </button>
    <#--<button class="layui-btn layui-btn-green"
            onclick="updateState('批量启用','eduCourseKpointTable','/educoursekpoint/enable')">
        <i class="fa fa-check-square-o">&nbsp;</i>启用
    </button>
    <button class="layui-btn  layui-btn-danger"
            onclick="updateState('批量禁用','eduCourseKpointTable','/educoursekpoint/disable')">
        <i class="fa fa-expeditedssl">&nbsp;</i>禁用
    </button>-->
    </@shiro.hasPermission>
    <@shiro.hasPermission name="educoursekpoint:delete">
        <button class="layui-btn layui-btn-delete"
                onclick="deleteBatch('批量删除','eduCourseKpointTable','/educoursekpoint/delete');">
            <i class="fa fa-trash-o">&nbsp;</i>删除
        </button>
    </@shiro.hasPermission>

</div>
<div class="layui-form ">
    <table class="layui-table" id="eduCourseKpointTable" cyType="pageGrid"
           cyProps="url:'/educoursekpoint/listData',checkbox:'true',pageColor:'#2991d9'">
        <thead>
        <tr>
            <!--复选框-->
            <th width="1%" param="{type:'checkbox'}">
                <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
            </th>
            <!--isPrimary：是否是主键-->
            <th width="5%" param="{name:'kpointId',isPrimary:'true',hide:'false'}">章节ID</th>

            <th width="5%" param="{name:'parentId'}">父级ID</th>

            <th width="10%" param="{name:'courseId'}">所属课程</th>

            <th width="15%" param="{name:'name'}">节点名称</th>

            <th width="10%" param="{name:'videoUrl'}">视频地址</th>

            <#--<th width="10%" param="{name:'isFree'}">是否可以试听1免费2收费</th>-->

            <th width="7%" param="{name:'playCount'}">播放量</th>

            <#--<th width="10%" param="{name:'teacherId'}">讲师id</th>-->

            <#--<th width="10%" param="{name:'playTime'}">播放时间</th>-->

            <th width="5%" param="{name:'kpointType', render: 'Render.kpointType'}">类型</th>

            <#--<th width="10%" param="{name:'videoType'}">视频类型</th>-->

            <#--<th width="10%" param="{name:'fileType'}">VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集</th>-->

            <#--<th width="10%" param="{name:'content'}">文本</th>-->

            <th width="5%" param="{name:'sort'}">排序</th>

            <th width="5%" param="{name:'createBy'}">创建人</th>

            <th width="7%" param="{name:'addTime'}">创建时间</th>

            <th width="5%" param="{name:'updateBy'}">更新人</th>

            <th width="7%" param="{name:'updateTime'}">更新时间</th>
            <!--isPrimary：渲染列-->
            <#--<th width="10%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>-->
            <th width="10%" param="{operate:'true',buttons:'Render.edit,Render.delete'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
</body>
</html>