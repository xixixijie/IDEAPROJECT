<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/24
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div align="center">
    <div class="div1">
      <div class="div2">
        <%
          String title = (String)request.getAttribute("title");
          String content = (String)request.getAttribute("content");
          if(title != null && !title.isEmpty()){
            out.println("<span class='tl'>" + title + "</span>");
          }
          if(content != null && !content.isEmpty()){
            out.println("<span class='ct'>" + content + "</span><br>");
          }
        %>
        <span class="tl">谢谢你们</span>
        <span class="ct">你们的公司服务态度非常好，谢谢你们！</span><br>
        <span class="tl">谢谢你们</span>
        <span class="ct">你们的公司服务态度非常好<br>但部分客服服务态度还要加强！</span><br>
        <form action="MessageServlet" method="post">
          <span class="tt">意见反馈</span>
          <table border="0" width="500" align="center">
            <tr>
              <td align="right">标 题：</td>
              <td><input type="text" name="title" size="30"></td>
            </tr>
            <tr>
              <td align="right">内 容：</td>
              <td>
                <textarea rows="5" cols="40" name="content"></textarea>
              </td>
            </tr>
            <tr>
              <td align="center" colspan="2">
                <input type="submit" value="提 交">
              </td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </div>

  </body>
</html>
