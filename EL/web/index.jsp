<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/28
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<%@page isELIgnored="true"%>
 禁用EL表达式-->
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    request.setAttribute("user","");
    request.setAttribute("user1",null);
  %>
  <!--判读是否为空jjo／-->
  ${empty user}
  <!--在EL表达式之前加 \ 如下-->
  \${"chenxijie"}
  <!--EL支持查找request ，session，application 和 page-->
  </body>
</html>
