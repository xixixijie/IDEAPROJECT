<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/20
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:useBean id="count" class="com.cxj.bean.Count" scope="application">
  </jsp:useBean>
  <% count.Add();%>
  访问次数:<jsp:getProperty name="count" property="count"/>
  </body>
</html>
