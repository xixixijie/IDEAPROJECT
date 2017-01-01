<%@ page import="Entity.UserEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.NewsEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>大学生社会实践平台</title>
    <link rel="stylesheet" href="css/nav.css" type="text/css"/>
    <link rel="stylesheet" href="css/homepage.css" type="text/css"/>
    <script language="javascript">
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
                form1.action = "userServlet?action=login&url=index.jsp";
                form1.submit();
            }
        }
        function logout(){
            javascipt:location.href='userServlet?action=logout&url=index.jsp';
        }

    </script>
</head>
<body>
<div id="container">

    <div id="header">
        <ul>
            <li><span><a href="首页.html" onClick="">加入收藏</a></span></li>
            <li><span><a href="首页.html">设为首页</a></span></li>
        </ul>
    </div>
    <div id="nav">
        <ul>
            <li><span><a target="_top" href="index.jsp">首页</a></span></li>
            <li><span><a target="_top" href="Module_practice/findTeacher.jsp">勤工助学</a></span></li>
            <li><span><a target="_top" href="Module_fit/fit.jsp">体育健身</a></span></li>
            <li><span><a target="_top" href="Module_community/community.jsp">团委社团</a></span></li>
            <li><span><a target="_top" href="首页.html">学术生活</a></span></li>
            <li><span><a target="_top" href="Module_competition/competition.jsp">科研竞赛</a></span></li>
            <li><span><a target="_top" href="Module_resource/resource.jsp">资源发布</a></span></li>
            <li><span><a target="_top" href="Module_outdoor/outdoor.jsp">户外交友</a></span></li>
        </ul>
    </div>
    <br/>
    <!--悬挂图片-->
    <div id="picture"></div>
    <!--登录窗口-->
    <div id="signIn">
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
    <!--下面是左中右三个框-->
    <br/>
    <div id="bigDiv">
        <div id="leftDiv">
            <div id="leftDiv1">
                <ul>
                    <li class="leftTitle"><span class="leftTitle">最新公告</span></li>
                    <%
                        List<NewsEntity> lD1= (List<NewsEntity>) request.getAttribute("lD1");
                        for(NewsEntity n:lD1){
                    %>
                    <li><span><a href="news/<%=n.getSrc()%>"><%=n.getTitle()%></a></span></li>
                 <%
                     }
                 %>
                </ul>
            </div>
            <br/>
            <div id="leftDiv2">
                <ul>
                    <li class="leftTitle"><span>社团资讯</span></li>
                    <%
                        List<NewsEntity> lD2= (List<NewsEntity>) request.getAttribute("lD2");
                        for(NewsEntity n:lD2){
                    %>
                    <li><span><a href="news/<%=n.getSrc()%>"><%=n.getTitle()%></a></span></li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
        <div id="centerDiv">
            <div id="centerDiv1">
                <ul>
                    <h1><span class="bigLetter">S</span><span class="centerTitle">社团活动</span></h1>
                    <%
                        List<NewsEntity> cD1= (List<NewsEntity>) request.getAttribute("cD1");
                        for(NewsEntity n:cD1){
                    %>
                    <li><span><a href="news/<%=n.getSrc()%>"><%=n.getTitle()%></a></span></li>
                    <%
                        }
                    %>
                </ul>
            </div>
            <br/>
            <div id="centerDiv2">
                <ul>
                    <h1><span class="bigLetter">K</span><span class="centerTitle">科技竞赛</span></h1>
                    <%
                        List<NewsEntity> cD2= (List<NewsEntity>) request.getAttribute("cD2");
                        for(NewsEntity n:cD2){
                    %>
                    <li><span><a href="news/<%=n.getSrc()%>"><%=n.getTitle()%></a></span></li>
                    <%
                        }
                    %>
                </ul>
            </div>
            <br/>
            <div id="centerDiv3">
                <ul>
                    <h1><span class="bigLetter">Z</span><span class="centerTitle">资源下载</span></h1>
                    <%
                        List<NewsEntity> cD3= (List<NewsEntity>) request.getAttribute("cD3");
                        for(NewsEntity n:cD3){
                    %>
                    <li><span><a href="news/<%=n.getSrc()%>"><%=n.getTitle()%></a></span></li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
        <div id="rightDiv">
            <ul>
                <li class="leftTitle"><span>失物招领</span></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
