<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户注册</title>
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


        .error-tips{
            color: red;
            font-family: "Songti SC", serif;
        }

    </style>

    <script type="text/javascript">
        function checkUserCode() {
            //获取用户输入的登录名称
            var userCode = $("#userCode").val();
            if(userCode.trim() === ""){
                //没有输入登录名，提示
                $("#userCodeError").addClass("error-tips");
                $("#userCodeError").text("用户名不能为空");
            }else{

                //传递用户名到后台去校验
                var url = "${pageContext.request.contextPath}/user_checkUserCode.do";
                var param = {"userCode":userCode};
                $.post(url, param, function (data) {
                    //操作data，判断data
                    if(data && data == "userExists"){
                        $("#userCodeError").addClass("error-tips");
                        $("#userCodeError").text("用户名已经存在");
                    }else{
                        $("#userCodeError").removeClass("error-tips")
                        $("#userCodeError").text("用户名不存在，可以注册");
                    }
                })
            }
        }


        // 可以阻止表单的提交
        function checkForm(){
            // 先让校验名称的方法先执行以下
            checkUserCode();
            // 获取error的数量，如果数量 > 0，说明存在错误，不能提交表单
            if($(".error-tips").size() > 0){
                return false;
            }
        }

    </script>
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
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#">开氪</a></li>
                <li><a href="#"><span style="font-family: Georgia,serif; font-size: 16px;">7x24h&nbsp;</span>快讯</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">创业者服务 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">投资人服务 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">联系我们 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="user_loginPage.do">登录</a></li>
                <li><a href="user_registerPage.do">注册</a></li>
                <li><a href="#">Link</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container" style="background-color: white; padding: 32px; border-radius: 8px;">

    <div style="margin-bottom: 20px;">
        <h3 style="display: inline">注册36氪，让创业更简单</h3>
        <a style="float: right; text-decoration: none" href="user_loginPage.do">使用已有账户登录</a>
    </div>
    <!-- onsubmit 阻止表单提交 -->
    <form class="form-signin" action="user_register.do" method="post" onsubmit="return checkForm()">


        <input type="text" id="userCode" name="userCode" class="form-control login" placeholder="注册用户名" onblur="checkUserCode()" required autofocus>
        <span id="userCodeError"></span>
        <br/>

        <!--<label for="inputPassword" class="sr-only">密码</label>-->
        <input type="password" id="userPassword" name="userPassword" class="form-control login" placeholder="登录密码" required>
        <br/>
        <input type="text" id="userName" name="userName" class="form-control login" placeholder="用户姓名" required>
        <br/>
        <%--<input type="password" id="xx" class="form-control login" placeholder="验证码" required>--%>
        <%--<br/>--%>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="font-size: 16px;font-family: 'Songti TC',serif">注册账号</button>
    </form>
</div>



<%--<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>--%>
<script type="text/javascript" rel="script" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" rel="script" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>