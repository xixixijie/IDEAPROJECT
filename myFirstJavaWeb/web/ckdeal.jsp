<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/17
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookies</title>
</head>
<body>
<%

    request.setCharacterEncoding("UTF-8");
    String user= URLEncoder.encode(request.getParameter("user"),"utf-8");
    String judge=URLEncoder.encode(request.getParameter("judge"));
    Cookie cookie=new Cookie("1",user+"#"+new java.util.Date().toLocaleString()+"#"+judge);
    cookie.setMaxAge(60*60*24*30);
    response.addCookie(cookie);

%>
<p>加入cookie成功</p>
</body>
</html>
