<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/1
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script language="JavaScript">
        function check() {
            if(form1.username.value==""){
                alert("请输入用户名!");
                form1.username.focus();
                return;
            }else if(form1.pswd.value==""){
                alert("请输入密码");
                form1.pswd.focus();
                return
            }else
            {
                form1.submit();
            }
        }
    </script>
</head>
<body>
<div align="center">
    <form name="form1" action="UserServlet" method="post">
        <table>
        <tr>
            <td colspan="2">
                用户注册
            </td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密  码:</td>
            <td><input type="password" name="pswd"></td>
        </tr>
        <tr>
            <td>
                <input type="button" onclick="check()" value="确定">
                <button type="button" name="button" value="" onclick="javascipt:location.href='index.jsp'">返回</button>
            </td>
        </tr>
        </table>
    </form>
</div>
</body>
</html>
