<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 31/05/2017
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    User u=(User) request.getAttribute("user");
%>
<frameset cols="40%,*" frameborder="0" name="a0">
    <frame noresize="noresize" name="a2" src="userServlet?action=get&id=<%=u.getId()%>">
    <frame noresize="noresize" name="a2" src="bkServlet" >
</frameset>
</html>
