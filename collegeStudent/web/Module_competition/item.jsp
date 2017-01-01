<%@ page import="Entity.NewsEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/16
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script language="Javascript">resizeTo(400,300)</script>
    <meta charset="utf-8">
    <title>科研竞赛</title>
    <link rel="stylesheet" href="../css/competition.css" type="text/css"/>
</head>
<body>
<div id="rightDiv" >
    <ul>
        <h1>竞赛项目</h1>
        <%
            List<NewsEntity> list= (List<NewsEntity>) request.getAttribute("list");
            for(NewsEntity n:list){
        %>
        <li><span><a href="news/<%=n.getSrc()%>"><%=n.getTitle()%></a></span></li>
        <%
            }
        %>
    </ul>
</div>
</body>
</html>
