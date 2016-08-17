<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/6/23
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder"%>
<html>
<head>
    <title>judge</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>
<%
    String namefi=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
    String pwdfi=new String(request.getParameter("pwd").getBytes("iso-8859-1"),"utf-8");
    String judge=new String(request.getParameter("Submit").getBytes("iso-8859-1"),"utf-8");


    if(judge.equals("注册")){
        session.setAttribute("namefi",namefi);
        session.setAttribute("pwdfi",pwdfi);
        response.sendRedirect("cookie.jsp");
    }


    Cookie[] cookies=request.getCookies();
    String name="";
    String pwd="";
    if(cookies!=null){
        for(int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals("myCookies"));
            name=URLDecoder.decode(cookies[i].getValue().split("#")[0]);
            pwd=cookies[i].getValue().split("#")[1];
            System.out.println(name+pwd);
            break;
        }
    }

    if(!name.equals(namefi)||!pwd.equals(pwdfi)){
        response.sendRedirect("error.jsp");
    }
    else{
%>
    <P>登陆成功</P>
<%
    }
%>




</body>
</html>
