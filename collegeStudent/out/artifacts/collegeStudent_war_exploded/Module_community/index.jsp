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
    <link rel="stylesheet" href="../css/community.css"
          type="text/css"/>

</head>
<frameset rows="400,*" frameborder="0" name="a0">
    <frame noresize="noresize" name="a1" src="head.jsp" />
    <frameset cols="300,*" frameborder="0">
        <frame noresize="noresize" name="a2" src="left.jsp" />
        <frame noresize="noresize" name="a3" src="/newsServlet?kind=community_committee" />
    </frameset>
</frameset>
</html>
