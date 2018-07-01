<%--
  Created by IntelliJ IDEA.

  Date: 31/05/2017
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script language="JavaScript">
      function check() {
        form1.action="userServlet?action=login";
        form1.submit();
      }
    </script>
  </head>
  <body>
    <form name="form1" action="" method="post">
      用户名：<input type="text" name="id" id="id">
      密码：<input type="password" name="pwd" id="pwd">
      <input type="button" value="登陆" onclick="check()">

      <a href="register.jsp">注册</a>
    </form>
  </body>
</html>
