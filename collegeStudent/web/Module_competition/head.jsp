<%@ page import="Entity.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/16
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>HomePage</title>
    <link rel="stylesheet" href="../css/nav.css" type="text/css"/>
    <link rel="stylesheet" href="../css/competition.css" type="text/css"/>
    <script language="JavaScript">
        function signCheck() {
            if (form1.id.value == "") {
                alert("请输入用户名");
                form1.id.focus();
                return;
            } else if (form1.pwd.value == "") {
                alert("请输入密码");
                form1.pwd.focus();
                return;
            } else {
                form1.action = "../userServlet?action=login&url=Module_competition/head.jsp";
                form1.submit();
            }
        }
        function logout(){
            javascipt:location.href='../userServlet?action=logout&url=Module_competition/head.jsp';
        }
    </script>
</head>
<body>
<div id="header" >
    <ul>
        <li><span><a href="首页.html" >加入收藏</a></span></li>
        <li><span><a href="首页.html" >设为首页</a></span></li>

    </ul>
</div>
<div id="nav">
    <ul>
        <li><span><a target="_top" href="../index.jsp">首页</a></span></li>
        <li><span><a target="_top" href="../Module_practice/findTeacher.jsp">勤工助学</a></span></li>
        <li><span><a target="_top" href="../Module_fit/fit.jsp">体育健身</a></span></li>
        <li><span><a target="_top" href="../Module_community/community.jsp">团委社团</a></span></li>
        <li><span><a target="_top" href="首页.html">学术生活</a></span></li>
        <li><span><a target="_top"  href="competition.jsp">科研竞赛</a></span></li>
        <li><span><a target="_top" href="../Module_resource/resource.jsp">资源发布</a></span></li>
        <li><span><a target="_top" href="../Module_outdoor/outdoor.jsp">户外交友</a></span></li>
    </ul>

</div>
<br/>
<!--悬挂图片-->
<div id="picture"></div>


<!--登录窗口-->
<div id ="signIn" >
    <%
        UserEntity u = (UserEntity) request.getSession().getAttribute("user");
        String error = (String) request.getAttribute("error");
        String id = (String) request.getAttribute("id");
        if (u == null && error == null) {
    %>
    <form name="form1" action="" method="post">
        用户名：
        <input type="text" class="input" name="id">
        密码：
        <input type="password" class="input" name="pwd">
        <input type="button" class="button" value="登录" onclick="signCheck()"/>
        <input type="button" class="button" value="注册" onclick="javascipt:location.href='register/register.jsp'"/>
        <span class="person"> 访问人数:<%=application.getAttribute("count")%></span>
    </form>

    <br/>
    <%
    } else if (error != null && error.equals("pwd")) {
    %>
    <script language="javascript">alert("密码错误");</script>
    <form name="form1" action="" method="post">
        用户名：
        <input type="text" class="input" name="id" value="<%=id%>">
        密码：
        <input type="password" class="input" name="pwd">

        <input type="button" class="button" value="登录" onclick="signCheck()"/>
        <input type="button" class="button" value="注册" onclick="javascipt:location.href='register/register.jsp'"/>
        <span class="person"> 访问人数:<%=application.getAttribute("count")%></span>
    </form>

    <br/>

    <%
    } else {
    %>
    <span class="welcome">你好，<%=u.getName()%></span>
    <span class="person"> 访问人数:<%=application.getAttribute("count")%></span>
    <button onclick="logout()" name="logout">注销</button>
    <%
        }
    %>
</div>
</body>
</html>
