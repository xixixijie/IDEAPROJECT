<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2018/7/6
  Time: 下午1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    function deleterUser() {
        document.forms[0].action="deleteUser.action";
        document.forms[0].submit();
    }
</script>
<body>
<form action="select.action" method="post">
    <button type="submit">登录</button>
</form>

<table>
    <tr>
        <th>用户</th>
        <th>年龄</th>
        <th>邮箱</th>
        <th>编辑</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.username}</td>
            <td>${u.age}</td>
            <td>${u.email}</td>
            <td><a href="editUser.action"></a></td>
        </tr>
    </c:forEach>

    <c:if test="${errors!=null}">
        <c:forEach items="${erroe}" var="error">
            ${error.defaultMessage}
        </c:forEach>
    </c:if>

</table>
</body>
</html>
