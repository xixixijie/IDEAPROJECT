<%@ page contentType="text/html;charset=UTF-8" language="java"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息修改</title>
    <style type="text/css">
        table.imagetable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
        }
        table.imagetable th {
            background:#b5cfd2 url('cell-blue.jpg');
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
        }
        table.imagetable td {
            background:#dcddc0 url('cell-grey.jpg');
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #999999;
        }

        .a_demo_two {
            background-color:#3bb3e0;
            padding:10px;
            position:relative;
            font-family: 'Open Sans', sans-serif;
            font-size:12px;
            text-decoration:none;
            color:#fff;
            background-image: linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
            background-image: -o-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
            background-image: -moz-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
            background-image: -webkit-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
            background-image: -ms-linear-gradient(bottom, rgb(44,160,202) 0%, rgb(62,184,229) 100%);
            background-image: -webkit-gradient(
                    linear,
                    left bottom,
                    left top,
                    color-stop(0, rgb(44,160,202)),
                    color-stop(1, rgb(62,184,229))
            );
            -webkit-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
            -moz-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
            -o-box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
            box-shadow: inset 0px 1px 0px #7fd2f1, 0px 6px 0px #156785;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            -o-border-radius: 5px;
            border-radius: 5px;
        }

        .a_demo_two::before {
            background-color:#072239;
            content:"";
            display:block;
            position:absolute;
            width:100%;
            height:100%;
            padding-left:2px;
            padding-right:2px;
            padding-bottom:4px;
            left:-2px;
            top:5px;
            z-index:-1;
            -webkit-border-radius: 6px;
            -moz-border-radius: 6px;
            -o-border-radius: 6px;
            border-radius: 6px;
            -webkit-box-shadow: 0px 1px 0px #fff;
            -moz-box-shadow: 0px 1px 0px #fff;
            -o-box-shadow: 0px 1px 0px #fff;
            box-shadow: 0px 1px 0px #fff;
        }

        .a_demo_two:active {
            color:#156785;
            text-shadow: 0px 1px 1px rgba(255,255,255,0.3);
            background:rgb(44,160,202);
            -webkit-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
            -moz-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
            -o-box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
            box-shadow: inset 0px 1px 0px #7fd2f1, inset 0px -1px 0px #156785;
            top:7px;
        }

        .a_demo_two:active::before {
            top:-2px;
        }
    </style>
    <script>
        <%
         String stum="20155036,1,college,major,man,name";//用数据库中参数代替
         String[] stums=new String[5];
         stums=stum.split(",");//split方式可能改变
        %>
        window.onload=function sexset(){
            if(<%=stums[4].equals("man")%>){
                document.getElementById("man").checked=true;
            }
            else{
                document.getElementById("woman").checked=true;
            }
        }
        function backHome(){
            window.location.href="index.jsp"//输入网址
        }
        function passwordChange(){
            var p1=document.getElementById("password");
            var p2=document.getElementById("passwordCheck");
            if(p1.value!=""&&p2.value!=""){
                if(p1.value!=p2.value){
                    alert("两次密码必须相同");
                }
            }
        }
        function spaceChange(str){
            var p1=document.getElementById(str);
            p1.value=p1.value.replace(/\s/g,"");
            document.getElementById(str).value=p1.value;
        }
        function allCheck(){
            var studentNumber=document.getElementById("studentNumber").value;
            var oldPassword=document.getElementById("oldPassword").value;
            var password=document.getElementById("password").value;
            var passwordCheck=document.getElementById("passwordCheck").value;
            var college=document.getElementById("college").value;
            var major=document.getElementById("major").value;
            var name=document.getElementById("name").value;
            if(studentNumber.length!=0&&oldPassword!=0&&password.length!=0&&passwordCheck.length!=0&&college.length!=0&&major.length!=0&&name.length!=0&&oldPassword.length!=0)
            {
                var p1=document.getElementById("oldPassword");
                if (p1.value==<%=stums[1]%>)
                {
                    reg.action="stuServlet?action=modify";
                    reg.submit();
                }
                else{
                    alert("原密码错误，请重新输入");
                }
            }
            else{
                alert("提交出错，请填写全部信息");
            }
        }
    </script>
</head>
<body bgcolor="#A4D3EE">
<div id="top" style="bgcolor:#A4D3EE; color:#000;height:20px" >
    欢迎你, <% out.println(stums[0]);%>
</div>
<%--<%@ include file="head.jsp" %>--%>
<div id="mid" align="center" style="margin:0 auto;background:#FFF; color:#000 ;width:80%;padding-top: 30px;padding-bottom: 30px">
    <form id=reg name=reg method="post">
        <table width="60%"  cellspacing="0" cellpadding="3" class="imagetable" width="417" border="0">
            <tr>
                <th>学号</th>
                <td><input type="text" name="studentNumber" id="studentNumber" value="<%=stums[0]%>" readonly=“true”/></td>
            </tr>
            <tr>
                <th>原密码</th>
                <td><input type="text" name="oldPassword" id="oldPassword" value="" onchange="pswCheck(this.id)"/></td>
            </tr>
            <tr>
                <th>新密码</th>
                <td><input type="text" name="password" id="password"value="" onchange="spaceChange(this.id)"/></td>
            </tr>
            <tr>
                <th>确认新密码</th>
                <td><input type="text" name="passwordCheck"  id="passwordCheck"value="" onchange="passwordChange()"/></td>
            </tr>
            <tr>
                <th>学院</th>
                <td><input type="text" name="college"  id="college"value="<%=stums[2]%>" onchange="spaceChange(this.id)"/></td>
            </tr>
            <tr>
                <th>专业</th>
                <td><input type="text" name="major"  id="major"value="<%=stums[3]%>" onchange="spaceChange(this.id)"/></td>
            </tr>
            <tr>
                <th>性别</th>
                <td><input type="radio" name="gender" id="man"value=""/>男<input type="radio" name="gender" id="woman"value=""/>女</td>
            </tr>
            <tr>
                <th>姓名</th>
                <td><input type="text" name="name" id="name"value="<%=stums[5]%>"  onchange="spaceChange(this.id)"/></td>
            </tr>
        </table>
    </form>
    <div id="btn"style="padding-top: 20px">
        <input type="submit" class="a_demo_two" value="修改" onclick="allCheck()">
        <button type="button" class="a_demo_two" id="back" onclick="backHome()" >返回主页</button>
    </div>
</div>
</body>
</html>
