<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/20
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:useBean id="user" class="com.cxj.bean.User">
    <jsp:setProperty name="user" property="id" value="1"/>
  </jsp:useBean>
  用户id:<jsp:getProperty name="user" property="id"/>
  </body>
</html>
