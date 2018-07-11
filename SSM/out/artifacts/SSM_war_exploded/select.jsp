<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        function deleteUser(){
            document.forms[0].action="deleteUser.action";
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<form action="selectUser.action"  method="post">
    <button type="submit" >查询</button>
    <div>
        <table>
            <tr>
                <th></th>
                <th>用户名</th>
                <th>年龄</th>
                <th>邮箱</th>
                <th>编辑</th>
            </tr>
            <c:forEach items="${resultList}"  var="u"  >
                <tr>
                    <td><input type="checkbox" name="userids" value="${u.id}" ></td>
                    <td>${u.username}</td>
                    <td>${u.age}</td>
                    <td>${u.email}</td>
                    <td><a href="editUser.action?userid=${u.id}"  >编辑</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <button type="button"  onclick="deleteUser()" >删除</button>
</form>
</body>
</html>