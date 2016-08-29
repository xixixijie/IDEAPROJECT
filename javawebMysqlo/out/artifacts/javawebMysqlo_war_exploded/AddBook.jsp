<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="common.Conn" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/25
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddBook</title>

</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="book" class="com.cxj.bean.Book"></jsp:useBean>
<jsp:setProperty name="book" property="*"></jsp:setProperty>
<%
    try{
        Conn.setConn();
        Connection conn= Conn.getConn();


        String sql="insert into tb_books(name,price,bookCount,author) values(?,?,?,?)";

        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,book.getName());
        ps.setDouble(2,book.getPrice());
        ps.setInt(3,book.getBookCount());
        ps.setString(4,book.getAuthor());
        int row=ps.executeUpdate();
        if(row>0){
            out.print("成功添加了"+row+"条信息");
        }
        ps.close();
        conn.close();
    }catch (Exception e){
        out.print("add book message fail");
        e.printStackTrace();
    }
%>
<br>
<a href="index.jsp">返回</a>
</body>
</html>
