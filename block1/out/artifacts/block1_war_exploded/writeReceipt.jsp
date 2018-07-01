<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2018/6/22
  Time: 下午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入回执</title>
    <script>
        function submitData() {
            document.forms[0].action="writeReceiptServlet";
            document.forms[0].submit();
//            confirm("录入完成");
//            window.close();
        }

        function closeWindow() {
            window.close();
        }
    </script>
</head>
<body>
录入回执
<form action="" method="post">
    <input type="hidden" name="taskID" value="${rtID}">
    客户评价：&nbsp;<input type="text" name="evaluate"><br>
    备&nbsp;&nbsp;注<input type="text" name="note"><br>
    <input type="button" onclick="submitData()" value="提交">
    <input type="button" onclick="closeWindow()" value="关闭">
</form>
</body>
</html>
