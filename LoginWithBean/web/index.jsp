<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/19
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form  method="post" action="reg.jsp">
    <table align="center" width="400" height="200" border="1">
      <tr>
        <td align="center" colspan="2" height="40">
          <b>添加用户信息</b>
        </td>
      </tr>
      <tr>
        <td align="center">姓 名:</td>
        <td>
          <input type="text" name="name">
        </td>
      </tr>
      <tr>
        <td align="right">年 龄:</td>
        <td>
          <input type="text" name="age">
        </td>
      </tr>
      <tr>
        <td align="right">性 别:</td>
        <td>
          <input type="text" name="sex">
        </td>
      </tr>
      <tr>
        <td align="right">住 址:</td>
        <td>
          <input type="text" name="add">
        </td>
      </tr>
      <tr>
        <td align="center" colspan="2">
          <input type="submit" value="添加">
        </td>
      </tr>
    </table>
  </form>
  </body>
</html>
