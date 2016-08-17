<%@ page import="com.lyq.bean.Email" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/25
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<div align="center"><%
    String mailAdd=request.getParameter("mailAdd");

    Email email=new Email(mailAdd);

    if(email.isEmail()){
        out.print(mailAdd+"<br>是一个标准的邮箱地址!<br>");
    }else{
        out.print(mailAdd+"<br>不是一个标准的邮箱地址!<br>");
    }
%>
    <a href="index.jsp">返回</a
</body>
</html>
