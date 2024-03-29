<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录--后台管理</title>
    <link rel="stylesheet" href="/statics/plugins/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="/statics/css/login.css" media="all"/>
    <script type="text/javascript">
        if (window != top) {
            top.location.href = location.href;
        }

    </script>
</head>
<body>
<#--<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="100%" data-width="100%"
       height="100%" width="100%">
    <source src="/login/login.mp4" type="video/mp4">
</video>-->

<div class="video_mask"></div>
<div class="login">
    <h1>管理员登录</h1>
    <form class="layui-form">
        <div class="layui-form-item">
            <input class="layui-input" name="username" placeholder="用户名" value="admin" lay-verify="required" type="text"
                   autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" placeholder="密码" value="admin" lay-verify="required"
                   type="password" autocomplete="off">
        </div>
        <div class="layui-form-item form_code">
            <input class="layui-input" style="width: 140px;" name="captcha" placeholder="验证码" lay-verify="required"
                   type="text" autocomplete="off" value="xxxx">
            <div class="code"><img id="captcha" src="/captcha.jpg" width="116" height="36" onclick="refreshCode(this)">
            </div>
        </div>
        <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
    </form>
</div>
<script type="text/javascript" src="/statics/plugins/layui/layui.js"></script>
<script type="text/javascript" src="/login/login.js"></script>
</body>
</html>