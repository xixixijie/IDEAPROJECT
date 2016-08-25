<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/25
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    try{
      Class.forName("com.mysql.jdbc.Driver");
      String url="jdbc:mysql://localhost:3306/test";
      String username="root";
      String password="00000000";
      Connection conn= DriverManager.getConnection(url,username,password);
      if(conn!=null){
        out.println("数据库连接成功");
        System.out.println("连接成功");
        conn.close();
      }else {
        out.println("连接失败");
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  %>
  </body>
</html>
