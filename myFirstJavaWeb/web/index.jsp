<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/14
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.net.URLDecoder" %>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=GB18030">
  <title>showtime</title>
</head>
<body>

<!--<%=new Date()%>-->
<%--<%
  Date date=new Date();
  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String today=df.format(date);
%>
<%=today%>
<br>
<%@ include file="top.jsp"%>
<%--

<jsp:forward page="login.jsp"/>--%>

<%--

<a href="test.jsp?id=1&user=">连接</a>


<%
  Cookie[] cookies=request.getCookies();
  String user="";
  String date="";
  String judge="";
  if(cookies!=null){
    for(int i=0;i<cookies.length;i++){
      if(cookies[i].getName().equals("1")){
        user= URLDecoder.decode(cookies[i].getValue().split("#")[0],"utf-8");//获取用户名
        date=cookies[i].getValue().split("#")[1];//获取注册时间
        judge=cookies[i].getValue().split("#")[2];//获取是否默认登陆
      }
    }
  }
  if("".equals(user)&&"".equals(date)){
%>
    您好，欢迎光临！
  <form action="ckdeal.jsp" method="post">
    请输入姓名:<input name="user" type="text" value=""><br>
    是否默认登陆：
    <input type="radio" name="judge" value="1">是
    <input type="radio" name="judge" value="0" checked>否
    <input type="submit" value="确定">

  </form>
<%
}else{
  if("1".equals(judge)){

%>
  欢迎[<b><%=user%></b>]再次光临<br>
  您注册的时间是<%=date%>
<%
  }
  else{
%>
游客您好，欢迎光临！
<form action="ckdeal.jsp" method="post">
  请输入姓名:<input name="user" type="text" value=<%=user%>><br>
  是否默认登陆：
  <input type="radio" name="judge" value="1">是
  <input type="radio" name="judge" value="0" checked>否
  <input type="submit" value="确定">
</form>
<%
   }
  }
%>

--%>


<%--<%response.sendRedirect("http://www.baidu.com");%>--%>
<%--<form id="form1" name="form1" method="post" action="session.jsp"  accept-charset="utf-8"
       onsubmit="document.charset='utf-8'">
  <div align="center">
    <table width="23%" border="0">
      <tr>
        <td width="36%"><div align="center">您的名字是</div></td>
        <td width="64%">
          <label>
            <div align="center">
              <input type="text" name="name"/>
            </div>
          </label>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <label>
            <div align="center">
              <input type="submit" name="Submit" value="提交">
            </div>
          </label>
        </td>
      </tr>
    </table>
  </div>
</form>
<%="chen jay"%>

<%response.setHeader("refresh","3;URL=heiheihei.jsp");%>
--%>



</body>
</html>
