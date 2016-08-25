<%@ page import="com.cxj.bean.UserInfoList" %>
<%@ page import="com.cxj.listener.MyListener" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/23
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

        <form action="showUser.jsp" method="post">
          <input type="text" id="user" name="user">
          <input type="submit">
        </form>
  </body>
</html>
