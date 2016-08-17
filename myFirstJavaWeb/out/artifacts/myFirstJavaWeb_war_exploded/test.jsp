<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<%
    String id=request.getParameter("id");
    String user=request.getParameter("user");
    String pwd=request.getParameter("pwd");
%>

<%=id%><br>
<%=user%><br>
<%=pwd%>
</body>
</html>
