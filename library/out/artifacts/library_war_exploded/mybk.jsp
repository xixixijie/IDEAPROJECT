<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 31/05/2017
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User u=(User)request.getAttribute("user");
%>
用户名：<%=u.getId()%>
余额：<%=u.getMoney()%>元
<form name="form1" action="userServlet?action=addMoney" method="post">
    <input type="text" name="money" id="money">元
    <input type="hidden" name="id" id="id" value="<%=u.getId()%>">
    <input type="submit" value="充值">
</form>
</body>
</html>
