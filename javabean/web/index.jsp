<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/25
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <form action="result.jsp" method="post">
    <table align="center" width="300" border="1" height="150">
      <tr>
        <td colspan="2" align="center">
          <b>邮箱认证系统</b>
        </td>
      </tr>
      <tr>
        <td align="right">邮箱地址：</td>
        <td><input type="text" name="mailAdd"/></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit"/>
        </td>
      </tr>
    </table>
  </form>
  </body>
</html>
