<%@page language="java" contentType="text/html; UTF-8"
        pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>后台管理主页</title>
    <meta name="keywords" content="36氪, 36kr, 36tr, 创业, 想创业, 投资, 融资,
    创投媒体, 创业公司, 科技新闻, 移动互联网, 资讯平台, 开放日, 互联网创业"/>
    <meta name="description" content="36氪是一个关注互联网创业的科技博客"/>
    <link rel="shortcut icon" href="//www.36kr.com/favicon.ico"/>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //提交分页查询的表单
        function to_page(page) {
            if(page){
                $("page").val(page);
            }
            //表单中 form 标签加上 name 属性
            document.customer_form.submit();
        }


        //页面加载完成
        $(document).ready(
            function () {
                var url = "<s:action name="findByCode" namespace="/dict"/>"
                var param = {"dictTypeCode":"006"};
                $.post(url, param, function(data){
                    alert(data);
                    //遍历
                    $.each(function(i,n){
                        alert(i + ":" + n.dictItemName);
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
                <a class="navbar-brand" href="#">
                    <img src="${pageContext.request.contextPath}/images/logo.png"
                                                      style="height: 25px; width:48px;">
                </a>
            </div>
            <div id="navbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="">当前登录：${u1.userCode}</a></li>
                    <li><a href="<s:action name="logOut" namespace="/dict"/>">安全退出</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <form id="customer_form" name="customer_form" action="#" method="post">
        <div class="container" style="padding-top: 100px;">
    <div class="row">
        <!-- 静态引入左边菜单-->
        <%@include file="left_menu.jsp"%>

        <div class="col-lg-10">
            <table class="table table-bordered">
                <tr>
                    <th style="font-family: Songti SC, serif;font-size: 18px;">客户名称</th>
                    <th style="font-family: Songti SC, serif;font-size: 18px;">客户级别</th>
                    <th style="font-family: Songti SC, serif;font-size: 18px;">客户来源</th>
                    <th style="font-family: Songti SC, serif;font-size: 18px;">联系人</th>
                    <th style="font-family: Songti SC, serif;font-size: 18px;">电话</th>
                    <th style="font-family: Songti SC, serif;font-size: 18px;">手机</th>
                </tr>

                <c:forEach items="${pageBean.beanList}" var="customer">
                    <tr>
                        <td style="font-family: Songti SC, serif;font-size: 18px;">${customer.custName}</td>
                        <td style="font-family: Songti SC, serif;font-size: 18px;">${customer.dictLevel.dictItemName}</td>
                        <td style="font-family: Songti SC, serif;font-size: 18px;">${customer.dictSource.dictItemName}</td>
                        <td style="font-family: Songti SC, serif;font-size: 18px;">${customer.custLinkman}</td>
                        <td style="font-family: Georgia, serif;font-size: 18px;">${customer.custPhone}</td>
                        <td style="font-family: Georgia, serif;font-size: 18px;">${customer.custMobile}</td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="6" align="center">
                        <span id="pageLink">
                            <div>
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">共</span>&nbsp;
                                [<span style="font-family: Georgia,serif; font-size: 16px;">${pageBean.totalCount}</span>]&nbsp;
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">条记录，</span>
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">共</span>
                                [<span style="font-family: Georgia,serif; font-size: 16px;">${pageBean.totalPage}</span>]
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">页， 每页显示</span>
                                
                                <select name="pageSize">
                                    <option value="3" <c:if test="${pageBean.pageSize==3}">selected</c:if>>3</option>
                                    <option value="5" <c:if test="${pageBean.pageSize==5}">selected</c:if>>5</option>
                                </select>
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">条。</span>
                                &nbsp;&nbsp;
                                <!-- 当前页小于大于 1 才有上一页-->
                                <c:if test="${pageBean.pageCode > 1}">
                                    <span style="font-family: 'Songti TC',serif;font-size: 16px;">
                                        [<a href="javascript:to_page(${pageBean.pageCode} -1)">上一页</a>]
                                    </span>
                                </c:if>

                                &nbsp;&nbsp;
                                <strong><span style="font-family: 'Georgia',serif; font-size: 16px">${pageBean.pageCode}</span></strong>
                                &nbsp;&nbsp;
                                <c:if test="${pageBean.pageCode < pageBean.totalPage}">
                                    <span style="font-family: 'Songti TC',serif;font-size: 16px;">
                                        [<a href="javascript:to_page(${pageBean.pageCode}+1)">下一页</a>]
                                    </span>
                                </c:if>
                                &nbsp;&nbsp;
                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">到</span>

                                     <input type="text" size="3" id="page" name="pageCode" />

                                <span style="font-family: 'Songti TC',serif;font-size: 16px;">页</span>

                                <input type="button" value="Go" onclick="to_page()"/>
                            </div>
                        </span>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
    </form>
</body>
</html>