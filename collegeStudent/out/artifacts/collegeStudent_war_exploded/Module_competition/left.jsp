<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/16
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script language="Javascript"></script>
    <meta charset="utf-8">
    <title>科研竞赛</title>
    <link rel="stylesheet" href="../css/competition.css" type="text/css"/>
</head>
<body>
<div id="leftDiv">
    <ul>
        <!--按从上到下的顺序分为1，2，3-->
        <li><span><a href="/newsServlet?kind=competition_team" class="left" target="a3">科研团队</a></span></li>
        <li><span><a href="/newsServlet?kind=competition_item" class="left" target="a3">竞赛项目</a></span></li>
        <li><span><a href="/newsServlet?kind=competition_corporation" class="left" target="a3">公司实习</a></span></li>
    </ul>
</div>
</body>
</html>
