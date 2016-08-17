<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/17
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session</title>
</head>
<body>
<%
    String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");//解决中文乱码问题
    session.setAttribute("name",name);
%>
<div align="center">
    <form id="form1" name="form1" method="post" action="result.jsp">
        <table width="28%" border="0">
            <tr>
                <td>您的名字是:</td>
                <td><%=name%></td>
            </tr>
            <tr>
                <td>您最喜欢去的地方是:</td>
                <td><lable>
                    <input type="text" name="address">
                </lable></td>
            </tr>
            <tr>
                <td colspan="2"><label>
                    <div align="center">
                        <input type="submit" name="Submit" value="提交">
                    </div>
                </label></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
