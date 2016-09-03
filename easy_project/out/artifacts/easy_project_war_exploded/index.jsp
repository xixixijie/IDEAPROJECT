<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/1
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>管理系统</title>
    <!--check()-->
    <script language="JavaScript">
      function check() {
        if(form1.username.value==""){
          alert("请输入用户名!");
          form1.username.focus();
          return;
        }else if(form1.pswd.value==""){
          alert("请输入密码");
          form1.pswd.focus();
          return
        }else
        {
          form1.submit();
        }
      }
    </script>
  </head>
  <body>
  <div align="center">
    <form name="form1" action="LoginServlet" method="post">
      <table>
      <tr>
        <td colspan="2">
          欢迎
        </td>
      </tr>
      <br>
      <tr>
        <td>用户名:</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>密  码:</td>
        <td><input type="password" name="pswd"></td>
      </tr>

      <tr>
        <td colspan="2" align="center">
        <input name="button" type="button" value="登录" onclick="check()">
        <button type="button" name="button" value="" onclick="javascipt:location.href='register.jsp'">注册</button>
        </td>
      </tr>
      </table>
    </form>
  </div>
  </body>
</html>
