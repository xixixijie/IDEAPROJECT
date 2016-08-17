<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/13
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script language="JavaScript">
      function trim() {
        var str=form1.oldString.value;
        if(str==""){
          alert("请输入字符串");
          form1.oldString.focus();
          return;
        }else{
          var objExp=/(^\s*)|(\s*$)/g;
          str=str.replace(objExp,"");
          form1.newString.value=str;
        }
      }

      function realSystime(clock) {
        var now=new Date();
        var year=now.getFullYear();
        var month=now.getMonth();
        var date=now.getDate();
        var day=now.getDay();
        var hour=now.getHours();
        var minu=now.getMinutes();
        var sec=now.getSeconds();
        month++;
        var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
        var week=arr_week[day];
        var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec;
        clock.innerHTML="当前时间："+time;
      }

      window.onload=function () {
        window.setInterval("realSystime(clock)",1000);
      }

      var elementList="";

    </script>
  </head>
  <body>
  <form name="form1" method="post" action="">
    oldstring:
    <textarea name="oldString" cols="40" rows="4"></textarea>
    newstring:
    <textarea name="newString" cols="40 " rows="4"></textarea>
    <input name="button" type="button" class="bto" value="确定" onclick="trim()">
  </form>
  <div id="clock"></div>
  </body>
</html>
