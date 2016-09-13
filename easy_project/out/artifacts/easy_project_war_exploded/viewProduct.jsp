<%@ page import="bean.Product" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/3
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看商品</title>
</head>
<body>
<%
    Product p= (Product) request.getAttribute("product");
%>
<div align="center">

    <table width=60% style="margin:auto">

        <tr>
            <td height=100>

            </td>
        </tr>
        <tr>
            <td >
                产品信息
            </td>
        </tr>
        <tr>
            <td>
                <table width = 99% border =1 >
                    <tr align="center">
                        <td width = 20%>产品名称</td>
                        <td width = 30%><%=p.getName() %></td>
                        <td width = 20%>产品价格</td>
                        <td><%=p.getPrice()%></td>


                    </tr>
                    <tr align="center">
                        <td >产品产地</td>
                        <td colspan=3><%=p.getAddress() %></td>


                    </tr>
                    <tr align="center">
                        <td>产品图片</td>
                        <%
                            System.out.println(request.getServletContext().getRealPath("\\"));
                            System.out.println(p.getImage());
                            String image=p.getImage();
                            System.out.println(image);
                        %>
                        <td colspan=3><img src="<%=image%>" width="300" height="200"/></td>

                    </tr>


                </table>
            </td>
        </tr>
        <tr>
            <td align="center">
                <button type="button" onclick="javascript:location.href='main.jsp'">确定</button>
                <button type="button" onclick="javascript:history.go(-1)">返回</button>
            </td>
        </tr>

    </table>


</div>

</body>
</html>
