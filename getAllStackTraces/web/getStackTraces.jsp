<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 06/04/2017
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器线程信息</title>
</head>
<body>
<%
    for(Map.Entry<Thread,StackTraceElement[]> stackTrace:Thread.getAllStackTraces().entrySet()){
        Thread thread=(Thread) stackTrace.getKey();
        StackTraceElement[] stack=(StackTraceElement[])stackTrace.getValue();
        if(thread.equals(Thread.currentThread())){
            continue;
        }
        out.println("\n线程："+ thread.getName());
        for(StackTraceElement element:stack){
            out.println("\t"+element+"\n");
        }
    }
%>
</body>
</html>
