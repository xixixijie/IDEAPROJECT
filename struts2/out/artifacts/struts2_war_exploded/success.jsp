<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 06/12/2016
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<!--
<div>
    <h1>操作普通属性</h1>
    属性name的值:<s:property value="name"/><br>
    学号:<s:property value="student.id"/><br>
    <!--
        也可以用<s:property value="student['id']"/><br>

    姓名:<s:property value="student.name"/><br>
    say方法:<s:property value="student.say()"/><br>

    request中的info值:<s:property value="#request['info']"/>
</div>
-->
<h2>用户注册信息</h2>
<ul>
    <li>用户名: <s:property value="name"/>
    <li>密码: <s:property value="password"/></li>
    <li>性别: <s:if test="sex==0">女</s:if><s:else>男</s:else> </li>
    <li>省份: <s:property value="province"/></li>
    <li>爱好: <s:property value="hobby"/></li>
    <li>描述: <s:property value="description"/></li>
</ul>
</body>
</html>
</div>