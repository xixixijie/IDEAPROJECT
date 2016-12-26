<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/24
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>ß
  </head>
  <body>
  <!--enctype="multipart/form-data" 在使用包含文件上传控件的表单时，必须使用该值。-->
  <form action="UploadServlet" enctype="multipart/form-data" method="post">
    <input type="file" name="file1" id="file1">
    <input type="submit" name="upload" value="上传">
  </form>
  </body>
</html>
