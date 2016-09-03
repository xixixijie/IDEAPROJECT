<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/28
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script language="JavaScript">
      function check() {
        if(form1.name.value==""){
          alert("请输入名字");
          form1.name.focus();
          return;
        }else if(form1.age.value==""){
          alert("请输入年龄");
          form1.age.focus();
          return;
        }else if(form1.sex.value==""){
          alert("请输入性别");
          form1.sex.focus();
          return;
        }else if(form1.StudentID.value==""){
          alert("请输入学号");
          form1.StudentID.focus();
          return;
        }else if(form1.phone.value==""){
          alert("请输入手机");
          form1.phone.focus();
          return;
        }else if(form1.academy.value==""){
          alert("请输入学院");
          form1.academy.focus();
          return;
        }else if(form1.major.value==""){
          alert("请输入专业");
          form1.major.focus();
          return;
        }else{
          form1.submit();
        }

      }
    </script>
  </head>
  <body>
  <form name="form1" action="RegisterServlet" method="post">
    name:<input type="text" name="name"><br>
    age:<input type="text" name="age"><br>
    sex:<input type="text" name="sex"><br>
    学号:<input type="text" name="StudentID"><br>
    phone:<input type="text" name="phone"><br>
    acdemy:<input type="text" name="academy"><br>
    major:<input type="text" name="major"><br>
    <input type="button" onclick="check()">


  </form>
  </body>
</html>
