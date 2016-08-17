<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/7/3
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>你好</title>
  </head>
  <body>
  <form name="login" id="login" method="post" action="http://118.202.10.24:8080/Servlet/web">
      <table height="150" border="0" align="center">
        <tr>
            <td>
              用户名：<input name="name" type="text" id="name" style="width: 120px">

            </td>
        </tr>
        <tr>
          <td>
            密&nbsp&nbsp码：<input name="pwd" type="password" id="pwd" style="width: 120px">
          </td>
        </tr>
        <tr>
          <td>
            <input name="login" type="submit" value="登陆">
            <a href="registor.jsp">注册新用户</a>
          </td>
        </tr>
      </table>
  </form>
  </body>
</html>
