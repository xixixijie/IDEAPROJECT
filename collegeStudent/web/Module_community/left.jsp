<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/16
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script language="Javascript"></script>
    <meta charset="utf-8">
    <title>团委社团</title>
    <link rel="stylesheet" href="../css/community.css" type="text/css"/>
</head>
<body>
<div id="leftDiv">
    <ul>
        <!--按从上到下的顺序分为1，2-->
        <li><span><a href="/newsServlet?kind=community_committee" class="left" target="a3">团委消息</a></span></li>
        <li><span><a href="/newsServlet?kind=community_activity" class="left" target="a3">社团活动</a></span></li>

    </ul>
</div>
</body>
</html>
