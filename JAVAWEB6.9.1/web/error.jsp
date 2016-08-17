<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/23
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<%="用户名或密码错误<br>将进入登陆界面"%>
<%
    response.setHeader("refresh","5;url=index.jsp");
%>
</body>
</html>
