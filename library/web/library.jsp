<%@ page import="java.util.List" %>
<%@ page import="bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 31/05/2017
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Book> bk= (List<Book>) request.getAttribute("bookcase");
%>
<ul>
    <li>例子 书名：哈哈 价格：呵呵</li>
    <%
        for(int i=0;i<bk.size();i++){
    %>
        <li>书名：<%=bk.get(i).getName()%>  价格：<%=bk.get(i).getPrice()%></li>
    <%
        }
    %>
</ul>
</body>
</html>
