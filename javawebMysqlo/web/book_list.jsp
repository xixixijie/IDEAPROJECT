<%@ page import="java.util.List" %>
<%@ page import="com.cxj.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/26
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book_list</title>
    <script language="JavaScript">
    function check() {
        var bookCount=form1.bookCount.value;
        if(bookCount==""){
            alert("没有填写数量");
            form1.bookCount.focus();
            return false;
        }else{
            return true;
        }

    }
    </script>
</head>
<body>
<table align="center" width="450" border="1">
    <tr>
        <td align="center" colspan="6"></td>
    </tr>
    <tr align="center">
        <td><b>ID</b></td>
        <td><b>图书名称</b></td>
        <td><b>价格</b></td>
        <td><b>数量</b></td>
        <td><b>作者</b></td>
        <td><b>修改</b></td>
    </tr>
    <%
        //获取图书信息合集
        List<Book> list=(List<Book>)request.getAttribute("list");
        //判断集合是否有效
        if(list==null||list.size()<1){
            out.print("没有数据!");
        }else{
            //遍历图书集合中的数据
            for(Book book:list){
    %>
    <tr align="center">
        <td><%=book.getId()%></td>
        <td><%=book.getName()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getBookCount()%></td>
        <td><%=book.getAuthor()%></td>
        <td>
            <form  name="form1" action="UpdateServlet" method="post" onsubmit="return check(this)">
                <input type="hidden" name="id" value="<%=book.getId()%>">
                <input type="text" name="bookCount" size="3" value="">
                <input type="submit" value="修改">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
