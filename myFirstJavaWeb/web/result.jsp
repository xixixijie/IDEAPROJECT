<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/17
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
    <meta content="text/html; charset=UTF-8">
</head>
<body>
<%
    String name=(String)session.getAttribute("name");
    String solution=new String(request.getParameter("address").getBytes("ISO-8859-1"),"utf-8");
%>
<form id="form1" name="form1" method="post" action="">
    <table width="28%" border="0">
        <tr>
            <td colspan="2"><div align="center"><strong>显示答案</strong></div> </td>
        </tr>
        <tr>
            <td width="49%"><div align="center">你的名字是：</div> </td>
            <td width="51%"><label><div align="left"><%=name%></div> </label></td>
        </tr>
        <tr>
            <td><label>
                <div align="left">您最喜欢的是：</div>
            </label></td>
            <td><div align="left"><%=solution%></div> </td>
        </tr>
    </table>
</form>

</body>
</html>
