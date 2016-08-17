<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/8/14
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script language="javascript">
      function countDown() {
        var now=new Date();
        var str=form1.date.value.split(".");
        var year=str[0];
        var month=str[1];
        var day=str[2];
       // alert("now:"+now.getFullYear()+"."+(now.getMonth()+1)+"."+now.getDate());
        var date=new Date(year,month-1,day);
        var time=Math.floor((date-now)/1000);
        var days=Math.floor(time/(24*60*60));

       show.value="距离"+year+"年"+month+"月"+day+"日 还剩"+days+"天";
        
      }
      
    </script>
  </head>
  <body>
  <form name="form1" method="post" action="">
    年.月.日<input name="date" type="text" id="date" size="23">
    <input name="Button" type="button" class="btn_grey" value="计算" onclick="countDown()">
    </form>
    <textarea id="show"></textarea>
  </body>
</html>
