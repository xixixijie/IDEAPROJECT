<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 13/12/2016
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="check" method="post">
    <s:textfield name="username" label="用户名" required="true"></s:textfield>
    <s:password name="password" label="密码" required="true"></s:password>
    <s:submit key="submit" value="登陆"></s:submit>
</s:form>
</body>
</html>
