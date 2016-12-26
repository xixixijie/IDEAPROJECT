<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/16
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>资源发布</title>
    <link rel="stylesheet" href="../css/resource.css" type="text/css"/>
</head>
<frameset rows="400,*" frameborder="0" name="a0">
    <frame noresize="noresize" name="a1" src="head.jsp" />
    <frameset cols="300,*" frameborder="0">
        <frame noresize="noresize" name="a2" src="left.jsp" />
        <frame noresize="noresize" name="a3" src="/newsServlet?kind=resource_video" />
    </frameset>
</frameset>
</html>
