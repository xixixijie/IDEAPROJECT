<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/24
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>利用监听使服务器端机器免登录</title>
  </head>
  <%

    String login=(String)request.getAttribute("login");
    if(login.equals("true")){
      response.sendRedirect("show.html");
    }


  %>
  <body><div align="center">

    <table width="335" height="225">
      <tr>
        <td  align="center">
          <form name="form1" method="post" action="show.htm">
            <input type="submit" name="Submit" value="登录">
          </form>

        </td>
      </tr>
    </table>
  </div>
  </body>
</html>
