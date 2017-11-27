<%--
  Created by IntelliJ IDEA.
  User: liqiwen
  Date: 2017/11/27
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; UTF-8"
        pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
    <a href="module/user.do"> 访问 UserAction</a>

    <br/>
    <a href="module2/muluser_deleteUser.do">通配符访问 Action -- 执行 delete</a>
    <br/>
    <a href="module2/muluser_saveUser.do">通配符访问 Action--执行 save</a>
    <br/>
    <a href="module2/muluser_updateUser.do">通配符访问 Action-- 执行 update</a>
    <br/>
    <a href="module3/dynamic!login.do">动态方法访问 Action--执行 login</a>
    <br/>
    <a href="module3/dynamic!register.do">动态方法访问 Action -- 执行 register</a>
    <br/>



</body>
</html>