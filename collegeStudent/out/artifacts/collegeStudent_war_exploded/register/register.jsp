<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/12
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="../css/nav.css" type="text/css"/>
    <link rel="stylesheet" href="../css/register.css" type="text/css"/>
    <script language="JavaScript">
        function register() {
            if (form1.id.value==""){
                alert("请输入学号");
                form1.id.focus();
                return;
            }else if(form1.name.value==""){
                alert("请输入用户名");
                form1.name.focus();
                return;
            }else if(form1.pwd.value==""){
                alert("请输入密码");
                form1.pwd.focus();
                return;
            }else if(form1.gender.value==""){
                alert("请选择性别");
                form1.gender.focus();
                return;
            }else if(form1.age.value==""){
                alert("请输入年龄");
                form1.age.focus();
                return;
            }else if(form1.university.value==""){
                alert("请输入学校");
                form1.university.focus();
                return;
            }else if(form1.college.value==""){
                alert("请输入学院");
                form1.college.focus();
                return;
            }else if(form1.major.value==""){
                alert("请输入专业");
                form1.major.focus();
                return;
            }else if(form1.email.value==""){
                alert("请输入邮箱");
                form1.email.focus();
                return;
            }
            form1.action="../userServlet?action=register";
            form1.submit();

        }
    </script>
</head>
<body>
<div id="container">

    <div id="header">
        <ul>
            <li><span ><a href="首页.html">加入收藏</a></span></li>
            <li><span><a href="首页.html">设为首页</a></span></li>

        </ul>
    </div>
    <div id="nav">

           <!-- <li onmouseover="this.style.background='#f00'" onmouseout="this.style.background='#000'"><span><a
                    href="首页.html">首页</a></span></li>-->
            <ul>
                <li><span><a target="_top" href="../index.jsp">首页</a></span></li>
                <li><span><a target="_top" href="../Module_practice/findTeacher.jsp">勤工助学</a></span></li>
                <li><span><a target="_top" href="../Module_fit/fit.jsp">体育健身</a></span></li>
                <li><span><a target="_top" href="../Module_community/community.jsp">团委社团</a></span></li>
                <li><span><a target="_top" href="首页.html">学术生活</a></span></li>
                <li><span><a target="_top" href="../Module_competition/competition.jsp">科研竞赛</a></span></li>
                <li><span><a target="_top" href="../Module_resource/resource.jsp">资源发布</a></span></li>
                <li><span><a target="_top" href="../Module_outdoor/outdoor.jsp">户外交友</a></span></li>
            </ul>

    </div>
    <br/>
    <!--悬挂图片-->
    <div id="picture"></div>


    <!--登录窗口-->
    <div id="signIn">
        <%
            User u=(User)request.getSession().getAttribute("user");
            String error= (String) request.getAttribute("error");
            String id=(String)request.getAttribute("id");
            if(u==null&&error==null){
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
        }else if(error!=null&&error.equals("pwd")){
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
        }else{
        %>
        <span class="welcome">你好，<%=u.getName()%></span>
        <span class="person"> 访问人数:<%=application.getAttribute("count")%></span>
        <%
            }
        %>
    </div>
    <!--下面是左中右三个框-->
    <div id="bigDiv">
        <div id="leftDiv"></div>
        <div id="rightDiv">
            <br>
            <br>
            <br>
            <div id="register">
                <form name="form1" action="" method="post">
                    学号: <input class="rInput" type="text" name="id"/><br>
                    姓名: <input class="rInput" type="text" name="name"/><br>
                    密码: <input class="rInput" type="password" name="pwd"/><br>
                    <div style="margin-bottom:20px">
                        性别: <input type="radio" name="gender" value="boy"/>男
                        <input type="radio" name="gender" value="girl"/>女<br>
                    </div>
                    年龄: <input class="rInput" type="text" name="age"><br>
                    学校: <input class="rInput" type="text" name="university"/><br>
                    学院:<input class="rInput" type="text" name="college"><br>
                    专业: <input class="rInput" type="text" name="major"/><br>
                    年级:<input class="rInput" type="text" name="grade"/><br>
                    邮箱: <input class="rInput" type="text" name="email"><br>
                    <br>
                    <input type="button" value="注册" id="rButton" onclick="register()">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
