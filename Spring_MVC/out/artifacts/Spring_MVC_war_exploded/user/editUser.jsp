<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2018/7/6
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="updateUser.action" method="post">
        <button type="submit">提交</button>
    </form>
    <p>${result.username}</p>
</div>
</body>
</html>
