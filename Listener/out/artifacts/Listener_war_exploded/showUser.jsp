<%@ page import="com.cxj.bean.UserInfoList" %>
<%@ page import="com.cxj.listener.MyListener" %>
<%@ page import="java.util.Vector" %>
<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/24
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    UserInfoList list=UserInfoList.getInstance();
    MyListener ml=new MyListener();
    String name=request.getParameter("user");
    ml.setUser(name);
    session.setAttribute(name,ml);
    list.addUserInfo(ml.getUser());
    session.setMaxInactiveInterval(60);
%>
<textarea rows="8" cols="20">
    <%
        Vector vector=list.getList();
        if(vector!=null&&vector.size()>0)
        {
            for(int i=0;i<vector.size();i++){
                out.println(vector.elementAt(i));
            }
        }
    %>
</textarea>
</body>
</html>
