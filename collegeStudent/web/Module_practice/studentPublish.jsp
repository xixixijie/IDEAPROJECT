<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/12
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>学生注册</title>
    <link rel="stylesheet" href="../css/nav.css" type="text/css"/>
    <link rel="stylesheet" href="../css/studentPublish.css" type="text/css"/>
    <script language="JavaScript">
        function publishCheck() {
            if(form2.name.value==""){
                alert("请输入名字");
                form2.name.focus();
                return;
            }else if(form2.age.value==""){
                alert("请输入年龄");
                form2.age.focus();
                return;
            }else if(form2.gender.value==""){
                alert("请输入性别");
                form2.gender.focus();
                return;
            }else if(form2.grade.value==""){
                alert("请输入年级");
                form2.grade.focus();
                return;
            }else if(form2.subject.value==""){
                alert("请输入科目");
                form2.subject.focus();
                return;
            }else if(form2.address.value==""){
                alert("请输入地址");
                form2.address.focus();
                return;
            }else if(form2.time.value==""){
                alert("请输入上课时间");
                form2.time.focus();
                return;
                //正则表达式验证邮箱 未完成
            }else if(form2.email.value==""){
                alert("请输入正确的邮箱格式");
                form2.email.focus();
                return;
            }
            form2.action="../stuServlet?action=publish";
            form2.submit();
        }

        function signCheck() {
                    if (form1.id.value == "") {
                        alert("请输入用户名");
                        form1.id.focus();
                        return;
                    } else if (form1.pwd.value == "") {
                        alert("请输入密码");
                        form1.pwd.focus();
                        return;
                    } else{
                        form1.action = "../userServlet?action=login&url=Module_practice/studentPublish.jsp";
                        form1.submit();
                    }
        }

        function logout(){
            javascipt:location.href='../userServlet?action=Module_practice/studentPublish.jsp';
        }

    </script>
</head>
<body>
<div id="container">

    <div id="header">
        <ul>
            <li><span><a href="首页.html">加入收藏</a></span></li>
            <li><span><a href="首页.html">设为首页</a></span></li>

        </ul>

    </div>
    <div id="nav">
        <ul>
            <li><span><a target="_top" href="../index.jsp">首页</a></span></li>
            <li><span><a target="_top" href="../Module_practice/findTeacher.jsp">勤工助学</a></span></li>
            <li><span><a target="_top" href="../Module_fit/fit.jsp">体育健身</a></span></li>
            <li><span><a target="_top" href="../Module_community/community.jsp">团委社团</a></span></li>
            <li><span><a target="_top" href="../首页.html">学术生活</a></span></li>
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
            User u = (User) request.getSession().getAttribute("user");
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
    <br/>
    <div id="main_body">
        <div id="stu">
            <div id="details">
                <form action="" method="post" name="form2">
                姓名:<input type="text" name="name"/><br>
                年龄:<input type="text" name="age"/><br>
                性别: <input  type="text" name="gender"/><br>
                年级: <input type="text" name="grade"/><br>
                科目:<input  type="text" name="subject"/><br>
                地址: <input type="text" name="address"/><br>
                上课时间:<input type="text" name="time"/><br>
                    邮箱地址:<input type="text" name="email"/><br>
                    <input type="button" onclick="publishCheck()" value="发布信息"/>
                    <input type="button" onclick="javascipt:location.href='findTeacher.jsp'" value="返回"/>

                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
