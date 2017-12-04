<%--
  Created by IntelliJ IDEA.
  User: liqiwen
  Date: 2017/12/4
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; UTF-8"
        pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<div class="col-lg-2">
    <div class="btn-group-vertical" role="group" align="center">
        <div class="btn-group" role="group">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                <span style="font-family: 'Songti TC',serif; font-size: 16px;">客户管理</span>
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
                <li><a href="${pageContext.request.contextPath}/lkm/list">联系人列表</a></li>
                <li><a href="${pageContext.request.contextPath}/lkm/addPage">新增联系人</a></li>
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