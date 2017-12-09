<%@ taglib prefix="s" uri="/struts-tags" %>
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

        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <!--<link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>-->
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
        <script type="text/javascript" rel="script" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" rel="script" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
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
                    var url = "<s:url action="checkUserCode" namespace="/user"/>";
                    <%--var url = "${pageContext.request.contextPath}/checkUserCode.do";--%>
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
                    <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/images/logo.png"
                                                          style="height: 25px; width:48px;"></a>
                </div>
                <div id="navbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<s:url namespace="/user" action="logPage"/>">登录</a></li>
                        <li><a href="<s:url namespace="/user" action="regPage"/>">注册</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container" style="background-color: white; padding: 32px; border-radius: 8px;">
            <div style="margin-bottom: 20px;">
                <h3 style="display: inline">注册 <span style="font-family: 'Songti TC', serif; font-size: 24px">36</span>  氪，让创业更简单</h3>
                <a style="float: right; text-decoration: none" href="<s:url namespace="/user" action="logPage"/>">使用已有账户登录</a>
            </div>
            <!-- onsubmit 阻止表单提交 -->
            <form class="form-signin" action="<s:url namespace="/user" action="register"/>" method="post"
                  onsubmit="return checkForm()">
                <input type="text" id="userCode" name="userCode" class="form-control login"
                       placeholder="注册用户名" onblur="checkUserCode()" required autofocus>
                <span id="userCodeError"></span>
                <br/>
                <input type="password" id="userPassword" name="userPassword" class="form-control login"
                       placeholder="登录密码" required>
                <br/>
                <input type="text" id="userName" name="userName" class="form-control login"
                       placeholder="用户姓名" required>
                <br/>
                <button class="btn btn-lg btn-primary btn-block" type="submit"
                        style="font-size: 16px;font-family: 'Songti TC',serif">注册账号</button>
            </form>
        </div>
    </body>
</html>