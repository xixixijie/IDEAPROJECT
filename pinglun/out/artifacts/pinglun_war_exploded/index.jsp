<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/13
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script language="javascript">
      function addElement() {
        var person=document.createTextNode(form1.person.value);
        var content=document.createTextNode(form1.content.value);

        var td_person=document.createElement("td");
        var td_content=document.createElement("td");
        var tr=document.createElement("tr");
        var tbody=document.createElement("tbody");

        td_person.appendChild(person);
        td_content.appendChild(content);

        tr.appendChild(td_person);
        tr.appendChild(td_content);

        tbody.appendChild(tr);

        var tComment=document.getElementById("comment");
        tComment.appendChild(tbody);

        form1.person.value="";
        form1.content.value="";

      }
    </script>
  </head>
  <body>
  <table width="600" border="1" align="center" cellpadding="0" bordercolor="#FFFFFF"
         bordercolorlight="#666666" bordercolordark="#FFFFFF" id="comment">
    <tr>
      <td width="18%" height="27" align="center" bgcolor="#E5BB93">评论人</td>
      <td width="82%" height="27" align="center" bgcolor="#E5BB93">评论内容</td>
    </tr>
  </table>

  <form name="form1" method="post" action="">
    评论人:<input name="person" type="text" id="person" size="40">
    评论内容:<textarea name="content" type="text" id="content"></textarea>
    <input name="Button" type="button" class="btn_grey" value="发表" onclick="addElement()">
  </form>
  </body>
</html>
