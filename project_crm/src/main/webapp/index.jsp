<%@page language="java" contentType="text/html; UTF-8"
        pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>后台管理主页</title>
    <meta name="keywords" content="36氪, 36kr, 36tr, 创业, 想创业, 投资, 融资, 创投媒体, 创业公司, 科技新闻, 移动互联网, 资讯平台, 开放日, 互联网创业"/>
    <meta name="description" content="36氪是一个关注互联网创业的科技博客"/>
    <link rel="shortcut icon" href="//www.36kr.com/favicon.ico"/>

    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
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
                <li><a href="">当前登录：${u1.userCode}</a></li>
                <li><a href="user_loginOut.do">安全退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" style="padding-top: 100px;">
    <div class="row">
        <div class="col-lg-2">
            <div class="btn-group-vertical" role="group" align="center">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default dropdown-toggle"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span style="font-family: 'Songti TC',Serif; font-size: 16px;">客户管理</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/customer/addPage">新增客户</a></li>
                        <li><a href="${pageContext.request.contextPath}/customer/list">客户列表</a></li>
                    </ul>
                </div>

                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span style="font-family: 'Songti TC',Serif; font-size: 16px;">联系人管理</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>

                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span style="font-family: 'Songti TC',Serif; font-size: 16px;">客户拜访管理</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>

                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span style="font-family: 'Songti TC',Serif; font-size: 16px;">综合查询</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>

                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span style="font-family: 'Songti TC',Serif; font-size: 16px;">统计分析</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span style="font-family: 'Songti TC',Serif; font-size: 16px;">移动管理</span>
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Dropdown link</a></li>
                        <li><a href="#">Dropdown link</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-lg-10">

            <span style="font-family: 'Songti TC',Serif; height: 200px;font-size: 36px;">欢迎登录客户关系管理系统</span>
        </div>
    </div>
</div>


</body>
</html>