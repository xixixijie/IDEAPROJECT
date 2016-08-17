<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/7/3
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>top page</title>
  </head>
  <body>
  <h2>欢迎光临,<br>
  您是本站的第[
    <%=application.getAttribute("count")%>
    ]位访客！
  </h2>
  </body>
</html>
