<#--  niushuai 2019-03-13 20:58:42-->

<html>
<head>
    <title>学生信息表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-label-left">id<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userId)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">学号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.stuNo)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">手机号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.mobile)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">邮箱号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.email)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">密码<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.password)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">用户名<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.userName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">昵称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.showName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">性别 1男 2女<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sex)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">年龄<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.age)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">注册时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">上次登录时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.lastLoginTime)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">上次登录IP<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.lastLoginIp)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">是否可用 1正常 0冻结<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.isAvalible)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">用户头像<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.picImg)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">个人中心用户背景图片<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.bannerUrl)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">站内信未读消息数<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.msgNum)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">系统发送的消息数量<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.sysMsgNum)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">上次查询系统消息时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.lastSystemTime)!"-"}</label>
        </div>
    </form>
</div>

</body>
</html>
