<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/20
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:useBean id="student" class="com.cxj.bean.Student"></jsp:useBean>
  <table align="center">
    <tr>
      <td>姓名</td>
      <td>      <jsp:getProperty name="student" property="name"></jsp:getProperty></td>
    </tr>
    <tr>
      <td>年龄</td>
      <td><jsp:getProperty name="student" property="age"></jsp:getProperty></td>
    </tr>
  </table>
  </body>
</html>
