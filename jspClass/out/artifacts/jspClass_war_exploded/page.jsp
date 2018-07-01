<%@ page import="java.util.List" %>
<%@ page import="bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>用户数据</h1></center>


<%
List<Student> list= (List) request.getAttribute("list");
int pageNumber=Integer.parseInt(""+request.getAttribute("page"));//请求页数
int pageSize=1;//一页有多少数据
int all=list.size();//总共的数据量
int pagen=0;//总共有的页数
int pageStart=(pageNumber-1)*pageSize;
if(all%pageSize==0){
	pagen=all/pageSize;
}else{
	pagen=(all/pageSize)+1;
}
%>
<center><h2>用户量为:<%=all %>&nbsp&nbsp&nbsp&nbsp每页显示<%=pageSize %>条数据&nbsp&nbsp&nbsp&nbsp</h2>
<br>
<h3><%=pageNumber %>/页<%=pagen %></h3>
</center>


<div style="text-align:center">
<table style="margin：0 auto">
<tr>
<th>学号</th>
<th>姓名</th>
<th>学院</th>
<th>专业</th>
<th>性别</th>
</tr>
<%for(int j=pageStart;j<pageStart+pageSize;j++){ %>
<tr>
<td><%=list.get(j).getId() %></td>
<td><%=list.get(j).getAcademy() %></td>
<td><%=list.get(j).getMajor() %></td>
<td><%=list.get(j).getName() %></td>
<td><%=list.get(j).getSex() %></td>
</tr>
<%if(j==(all-1)){break;} %>
<%} %>
</table>

<%for(int i=1;i<(pagen+1);i++){%>
	<a href="stuServlet?action=divide&page=<%=i %>">[<%=i %>]</a>
<% } %>
</div>
</body>
</html>