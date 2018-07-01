<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="renderer" content="webkit">
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="../bc.css" rel="stylesheet">
    <link href="../login.css" rel="stylesheet">
    <script language="JavaScript">
        function login(){
            rtloginform.action="stuServlet?action=login"
            rtloginform.submit();
        }
    </script>
</head>
<body>
<div id="doc">
    <div id="hd">
    </div>
    <div id="bd">
        <div class="mod-login">
            <div class="title">
                <img src="../logo.png" height="124">
            </div>
            <div class="pic">
                <img src="../xiaohui.png" width="157" height="156">
            </div>

            <form id="rtloginform" name="rtloginform" method="post" class="form-login">
                用户名<input name="username" type="text" value="">
                密码<input name="password" type="password" value="">
                <button onclick="login()">denglu</button>
                    <div class="form-item"><em class="t"></em>
                </div>
                <div class="form-contral">
                    <a id="btnRtSubmit" class="btn-login" href="index.jsp"></a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>