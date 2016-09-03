<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/3
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码错误</title>
</head>
<body>
<%="用户名或密码错误<br>将进入登陆界面"%>
<%
    response.setHeader("refresh","3;url=index.jsp");
%>

</body>
</html>
