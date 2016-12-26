<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/16
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>资源发布</title>
    <link rel="stylesheet" href="../css/resource.css" type="text/css"/>
</head>
<body>
<div id="leftDiv">
    <ul><!--按从上到下的顺序分为1，2，3-->
        <li><span><a href="/newsServlet?kind=resource_video" class="left" target="a3">影视资源</a></span></li>
        <li><span><a href="/newsServlet?kind=resource_study" class="left" target="a3">学术资源</a></span></li>
        <li><span><a href="/newsServlet?kind=resource_software" class="left" target="a3">软件资源</a></span></li>
    </ul>
</div>
</body>
</html>
