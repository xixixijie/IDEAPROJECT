<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/18
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.lyq.bean.Email" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<div align="center">
    <%
        //获取邮箱地址
        String mailAdd=request.getParameter("mailAdd");
        //实例化Email
        Email email=new Email(mailAdd);
        //judge
        if(email.isEmail()){
            out.print(mailAdd+"<br>是一个正确的邮箱地址");
        }else{
            out.print(mailAdd+"<br>不是一个正确的邮箱地址");
        }
    %>
    <a href="index.jsp">返回</a>
</div>
</body>
</html>
