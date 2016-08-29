<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/28
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list</title>
</head>
<body>
<table align="center" width="450" border="1">
    <tr>
        <td align="center" colspan="5">
            <h2>所有商品信息</h2>
        </td>
    </tr>
    <tr align="center">
        <td><b>ID</b></td>
        <td><b>商品价格</b></td>
        <td><b>价格</b></td>
        <td><b>数量</b></td>
        <td><b>单位</b></td>
    </tr>
    <%
        List<Product> list=(List<Product>)request.getAttribute("list");
        for(Product p:list){
    %>
    <tr align="center">
        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td><%=p.getNum()%></td>
        <td><%=p.getUnit()%></td>
    </tr>
    <%
        }
    %>
    <tr>
        <td align="center" colspan="5" height="30">
            <%=request.getAttribute("bar")%>
        </td>
    </tr>
</table>
</body>
</html>
