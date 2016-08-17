<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/7/3
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页</title>
</head>
<body>
<form name="registor" id="registor" method="post"
      action="http://localhost:8080/Servlet/web1">
    <table align="center">
        <tr>
            <td>
                用户名：<input name="name" id="name" type="text" style="width: 120px">
            </td>
        </tr>
        <tr>
            <td>
                密&nbsp&nbsp码：<input name="pwd" type="text" id="pwd" style="width: 120px">
            </td>
        </tr>
        <tr>
            <input name="confirm" type="submit" value="确认注册">
        </tr>
    </table>
</form>
</body>
</html>
