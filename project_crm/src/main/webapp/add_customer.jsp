<%--
  Created by IntelliJ IDEA.
  User: liqiwen
  Date: 2017/11/30
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">

        //页面加载完成
        $(document).ready(
            //获取客户级别
            function () {
                var url = "${pageContext.request.contextPath}/dict/findByCode";
                var param = {"dictTypeCode":"002"};
                $.post(url, param, function(data){
                    //遍历
                    $(data).each(function(i,n){
                        $("#sourceId").append("<option value='"+n.dictId+"'>"+n.dictItemName+"</option>");
                    })
                }, "json");
            }
        );

        $(document).ready(
            function(){
                var url = "${pageContext.request.contextPath}/dict/findByCode";
                var param = {"dictTypeCode":"006"};
                $.post(url, param, function(data){
                    $(data).each(function(i, n){
                        $("#levelId").append("<option value='"+n.dictId+"'>"+n.dictItemName+"</option>");
                    })
                }, "json");
            }
        );

    </script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/images/logo.png" style="height: 25px; width:48px;"></a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="">当前登录：${u1.userCode}</a></li>
                <li><a href="user_loginOut.do">安全退出</a></li>
            </ul>
        </div>
    </div>
</nav>
<form id="customer_form" name="customer_form" action="${pageContext.request.contextPath}/customer/add" method="post">
<div class="container" style="padding-top: 100px;">
    <div class="row">
        <%@ include file="left_menu.jsp" %>
        <div class="col-lg-10">

            <table class="table table-bordered">
                <tr>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">客户名称</td>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">
                        <input type="text" name="custName">
                    </td>
                </tr>

                <tr>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">客户级别</td>
                    <td style="font-family: Songti SC, serif;font-size: 16px;">
                        <select id="levelId">

                        </select>
                    </td>
                </tr>

                <tr>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">客户来源</td>
                    <td style="font-family: Songti SC, serif;font-size: 16px;">
                        <select id="sourceId">

                        </select>
                    </td>
                </tr>

                <tr>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">联系人</td>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">
                        <input type="text" name="custLinkman">
                    </td>
                </tr>

                <tr>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">电话</td>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">
                        <input type="text" name="custPhone">
                    </td>
                </tr>

                <tr>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">手机</td>
                    <td style="font-family: Songti SC, serif;font-size: 18px;">
                        <input type="text" name="custMobile">
                    </td>
                </tr>


                <tr>
                    <td colspan="2">
                        <button class="button btn-primary btn-block" type="submit">保存客户</button>
                    </td>
                </tr>


            </table>
        </div>
    </div>
</div>
</form>


</body>
</html>