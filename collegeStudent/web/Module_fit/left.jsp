<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/16
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script language="Javascript"></script>
    <meta charset="utf-8">
    <title>体育健身</title>
    <link rel="stylesheet" href="../css/fit.css"
          type="text/css"/>
</head>
<body>
<div id="leftDiv">
    <ul>
        <!--按从上到下的顺序分为1，2，3-->
        <li><span><a href="/newsServlet?kind=fit_article" class="left" target="a3">健身好文</a></span></li>
        <li><span><a href="/newsServlet?kind=fit_app" class="left" target="a3">健身APP</a></span></li>
        <li><span><a href="/newsServlet?kind=fit_gym" class="left" target="a3">体育馆</a></span></li>
    </ul>
</div>
</body>
</html>
