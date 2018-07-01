<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新用户注册</title>

    <script type=text/javascript>
        function studentNumberChange(){
            var re = /^[0-9]*[1-9][0-9]*$/ ;
            var studentNumber=document.getElementById("studentNumber").value;
            var nu=document.getElementById("nu");
            nu.innerHTML=""
            if(studentNumber.length!=0){
                if(studentNumber.length!=8){
                    nu.innerHTML="<b>学号位数错误</b>"
                    document.getElementById("studentNumber").innerHTML+="<style>b{color:#f00}</style>"
                }
                if(!re.test(studentNumber)){//判断学号全部为数字
                    nu.innerHTML="<b>学号应全为数字</b>"
                    document.getElementById("studentNumber").innerHTML+="<style>b{color:#f00}</style>"			}
            }
        }
        function spaceChange(str){
            var p1=document.getElementById(str);
            p1.value=p1.value.replace(/\s/g,"");
            document.getElementById(str).value=p1.value;
        }
        function passwordChange(){
            var p1=document.getElementById("password");
            var p2=document.getElementById("passwordCheck");
            var nu=document.getElementById("second");
            nu.innerHTML="";
            if(p1.value!=""&&p2.value!=""){
                if(p1.value!=p2.value){
                    nu.innerHTML="<b>密码确认错误</b>"
                    document.getElementById("passwordCheck").innerHTML+="<style>b{color:#f00}</style>"			}
            }
        }
        function allCheck(){
            var studentNumber=document.getElementById("studentNumber").value;
            var password=document.getElementById("password").value;
            var passwordCheck=document.getElementById("passwordCheck").value;
            var college=document.getElementById("college").value;
            var major=document.getElementById("major").value;
            var name=document.getElementById("name").value;
            if(studentNumber.length!=0&&password.length!=0&&passwordCheck.length!=0&&college.length!=0&&major.length!=0&&name.length!=0){
                reg.action="stuServlet?action=register";
                reg.submit();
            }
            else{
                alert("提交出错，请检查您填写的信息是否正确");
            }


        }

    </script>
</head>
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

<body  bgcolor="#A4D3EE">
<center>
    <h1>新用户注册</h1>
    <form id=reg name=reg method="post">
        <table class="imagetable" width="417" border="0">
            <tr>
                <td width="82" height="33"><table width="454" border="0">
                    <tr>
                        <th width="85" height="32">学号</th>
                        <td width="195"><input type="text" id="studentNumber" name="studentNumber" onchange="studentNumberChange();spaceChange(this.id)"  /></td>
                        <td width="123" id="nu">&nbsp;<%=request.getAttribute("error")%></td>
                    </tr>
                    <tr>
                        <th height="33">密码</th>
                        <td><input type="password" id="password" name="password" onchange="spaceChange(this.id)"/></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <th height="33">确认密码</th>
                        <td><input type="password" id="passwordCheck" name="passwordCheck" onchange="passwordChange();spaceChange(this.id)"/></td>
                        <td id="second">&nbsp;</td>
                    </tr>
                    <tr>
                        <th height="33">学院</th>
                        <td><input type="text" id="college" name="college"  onchange="spaceChange(this.id)"/></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <th height="33">专业</th>
                        <td><input type="text" id="major" name="major"  onchange="spaceChange(this.id)"/></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <th height="33">姓名</th>
                        <td><input type="text" id="name" name="name"  onchange="spaceChange(this.id)"/></td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <th height="33">性别</th>
                        <td><input type="radio" name="gender" id="man" value="man" checked="checked"/>
                            男
                            <input type="radio" name="gender" value="woman" id="woman" />
                            女</td>
                        <td>&nbsp;</td>
                    </tr>
                </table></td>
            </tr>
        </table>
        <br>
        <input class="a_demo_two" type="submit" value="          注册             " onclick="allCheck()">
    </form>

</center>
</body>
</html>