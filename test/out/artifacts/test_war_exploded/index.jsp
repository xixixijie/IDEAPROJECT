<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/28
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script language="JavaScript">
      function check() {
        var str=form1.name1.value;
        if(str==""){
          alert("请输入");
          form1.name1.focus();
          return false;
        }else{
          return true;
        }
      }
    </script>
  </head>
  <body>
  <form name="form1" action="" method="post" onsubmit="return check()">
    <input name="name1" type="text">
    <input type="submit">
  </form>
  </body>
</html>
