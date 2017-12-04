<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户登录</title>
    <meta name="keywords" content="36氪, 36kr, 36tr, 创业, 想创业, 投资, 融资, 创投媒体, 创业公司, 科技新闻, 移动互联网, 资讯平台, 开放日, 互联网创业"/>
    <meta name="description" content="36氪是一个关注互联网创业的科技博客"/>
    <link rel="shortcut icon" href="//www.36kr.com/favicon.ico"/>

    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <!--<link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>-->
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <style>
        body {
            padding-top: 200px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin {
            margin-bottom: 10px;
        }


        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }


        <!-- 获取焦点有2cm 的偏移产生阴影 -->
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            border-bottom-right-radius: 4px;
            border-bottom-left-radius: 4px;
        }
        .form-signin input[type="password"] {
            border-top-left-radius: 4px;
            border-top-right-radius: 4px;
        }

    </style>

</head>
<body>


<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <!-- The mobile navbar-toggle button can be safely removed since you do not need it in a non-responsive implementation -->
            <a class="navbar-brand" href="#"><img src="images/logo.png" style="height: 25px; width:48px;"></a>
        </div>
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="user_loginPage.do">登录</a></li>
                <li><a href="user_registerPage.do">注册</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container" style="background-color: white; padding: 32px; max-width: 400px; border-radius: 8px;">

    <form class="form-signin" action="user_login.do" method="post">
        <div style="margin-bottom: 20px">
            <h3 style="display: inline">账号密码登录</h3>
            <a style="float: right; text-decoration: none" href="user_registerPage.do">注册新用户</a>
        </div>
        <!--<label for="inputEmail" class="sr-only">用户名</label>-->
        <input type="text" id="userCode" name="userCode" class="form-control login" placeholder="用户名" required autofocus>
        <br/>

        <input type="password" id="userPassword" name="userPassword" class="form-control login" placeholder="登录密码" required autofocus>
        <br/>
        <div>
            <a href="#" style="text-decoration: none">忘记登录密码</a>
        </div>
        <br/>
        <button class="btn btn-lg btn-success btn-block" type="submit" style="font-size: 16px; font-family: 'Songti TC',serif">立即登录</button>
    </form>
</div>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" rel="script" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>