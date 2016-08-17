<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/23
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie</title>
</head>
<body>
<%
    String name= URLEncoder.encode((String) session.getAttribute("namefi"),"utf-8");
    String pwd= (String) session.getAttribute("pwdfi");
    Cookie cookie=new Cookie("my",name+"#"+pwd);
    cookie.setMaxAge(60*60);
    response.addCookie(cookie);

    response.setHeader("refresh","5;URL=index.jsp");

%>
你的用户名为：<%=name%>
你的密码&nbsp&nbsp为：<%=pwd%>
<%="注册成功"%>
</body>
</html>
