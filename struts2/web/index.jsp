<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 05/12/2016
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/chen/first">test</a>
  <a href="userAction">test2</a>
  <a href="userAction_add">添加用户</a>
  <a href="userAction_update">更新用户</a>

<!--
  <s:form action="userAction" method="post">
    <s:textfield name="user.name" label="用户名"></s:textfield>
    <s:password name="user.password" label="密码"></s:password>
    <s:radio list="#{1:'男',0:'女'}" name="user.sex" label="sex"></s:radio>
    <s:submit value="注册"></s:submit>
  </s:form>
-->

  <h2>用户注册</h2>
  <s:form action="userAction!register" method="post">
    <s:textfield name="name" label="用户名" requiredPosition="left"></s:textfield>
    <s:password name="password" label="密码" requiredPosition="left"></s:password>
    <s:radio list="#{1:'男',0:'女'}" name="sex" label="性别" required="true" requiredPosition="left"></s:radio>
    <s:select list="{'请选择身份','吉林','广东','山东','河南'}" name="province" label="性别"></s:select>
    <s:checkboxlist list="{'足球','羽毛球','乒乓球','篮球'}" name="hobby" label="爱好"></s:checkboxlist>
    <s:textarea name="description" cols="30" rows="5" label="描述"></s:textarea>
    <s:submit value="注册"></s:submit>
    <s:reset value="重置"></s:reset>

  </s:form>





  <a href="test.action">Map</a>


  <a href="login.jsp">注册</a>
  </body>
</html>
