<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/20
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reg</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="person" class="com.cxj.Bean.Person" scope="page">
    <jsp:setProperty name="person" property="*"/>
</jsp:useBean>
<table align="center" width="400">
    <tr>
        <td align="right">姓名：</td>
        <td>
            <jsp:getProperty name="person" property="name"></jsp:getProperty>
        </td>
    </tr>
    <tr>
        <td align="right">年龄：</td>
        <td>
            <jsp:getProperty name="person" property="age"></jsp:getProperty>
        </td>
    </tr>
    <tr>
        <td align="right">性别：</td>
        <td>
            <jsp:getProperty name="person" property="sex"></jsp:getProperty>
        </td>
    </tr>
    <tr>
        <td align="right">住处：</td>
        <td>
            <jsp:getProperty name="person" property="add"></jsp:getProperty>
        </td>
    </tr>
</table>
</body>
</html>
