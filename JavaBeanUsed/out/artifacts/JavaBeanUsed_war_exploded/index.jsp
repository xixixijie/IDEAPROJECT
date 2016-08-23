<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/18
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <jsp:useBean id="produce" class="com.cxj.bean.Produce"></jsp:useBean>
  <jsp:setProperty name="produce" property="name" value="洗衣机"></jsp:setProperty>
  <jsp:setProperty name="produce" property="price" value="888.88"></jsp:setProperty>
  <jsp:setProperty name="produce" property="count" value="88"></jsp:setProperty>
  <jsp:setProperty name="produce" property="factoryAdd" value="广东省"></jsp:setProperty>
  <div>
    <ul>
      <li>
        商品名称:<jsp:getProperty name="produce" property="name"></jsp:getProperty>
      </li>
      <li>
        价格：<jsp:getProperty name="produce" property="factoryAdd"></jsp:getProperty>
      </li>
      <li>
        数量:<jsp:getProperty name="produce" property="count"></jsp:getProperty>
      </li>
      <li>
        厂址:<jsp:getProperty name="produce" property="factoryAdd"></jsp:getProperty>
      </li>
    </ul>
  </div>

  </body>
</html>
