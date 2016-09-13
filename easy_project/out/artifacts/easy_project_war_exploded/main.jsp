<%@ page import="bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.ProDao" %><%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/2
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <script language="JavaScript">
        function searchProduct() {
            var form2 = document.form2;
            form2.action = "DivideServlet";
            form2.submit();
        }


        function addProduct() {
            var form2 = document.form2;
            form2.action = "AddProServlet";
            form2.submit();
        }

        function selectAll(flag) {

            var ids = document.getElementsByName("ids");
            for (var i = 0; i < ids.length; i++) {
                ids[i].checked = flag;
            }

        }
        function first() {
            window.location.href = "DivideServlet?page=1";
        }
        function forward() {
            var currpage = new String(<%=request.getAttribute("currPage")%>);
            var page = currpage.valueOf() - 1;
            if (page == 0) {
                page = 1;
            }
            window.location.href = "DivideServlet?page=" + page;
        }
        function next() {
            var currpage = new String(<%=request.getAttribute("currPage")%>).valueOf();
            var maxpage = new String(<%=request.getAttribute("maxpage")%>).valueOf();
            if (maxpage != currpage) {
                currpage++;
            }
            window.location.href = "DivideServlet?page=" + currpage;
        }
        function end() {
            var page = new String(<%=request.getAttribute("maxpage")%>);

            window.location.href = "DivideServlet?page=" + page;
        }

        function change(currpage) {
            window.location.href = "DivideServlet?page=" + currpage;
        }

        function addProduct() {
            window.location.href = "addProduct.jsp";
        }

        function getSelectedCount() {

            var ids = document.getElementsByName("ids");
            var count = 0;
            for (var i = 0; i < ids.length; i++) {

                ids[i].checked == true ? count++ : 0;
            }
            return count;

        }

        function del() {
            if (getSelectedCount() == 0) {
                alert("至少选择一个删除项！");
                return;
            }

            var th = document.form1;
            th.action = "DivideServlet";
            th.submit();
        }

        function getSelectedValue() {
            var ids = document.getElementsByName("ids");
            for (var i = 0; i < ids.length; i++) {
                if (ids[i].checked) {
                    return ids[i].value;
                }
            }
        }

        function view(){
            if(getSelectedCount()<1){

                alert("至少选择一个查看项！");
                return;

            }else if(getSelectedCount()>1){
                alert("只能选择一个查看项！");
                return;
            }

            var th = document.form1;
            th.action="ViewServlet?proid="+getSelectedValue();
            th.submit();
        }
    </script>
</head>
<body>
<%
    String username = (String) session.getAttribute("username");
%>


<div>
    <table width=60% align="center">
        <tr>
            <td align="left"><font size=2>欢迎您的光临，<%=username%><br><a href="LogoutServlet">退出</a></font></td>
        </tr>
        <tr>
            <td align="center">
                <form name="form2" action="" method="post">
                    <table>
                        <tr>
                            <td colspan="2">产品信息查询</td>

                        </tr>
                        <tr>
                            <td>产品名称</td>
                            <td><input type="text" name="proname" value=""/></td>

                        </tr>

                        <tr>
                            <td colspan="2" align="center">
                                <button type="button" onclick="searchProduct()">查询</button>
                                <button type="button" onclick="addProduct()">添加</button>

                            </td>
                        </tr>
                    </table>
                </form>

            </td>
        </tr>

        <tr>
            <td height=50></td>
        </tr>
        <tr>
            <td> 查询结果</td>
        </tr>

        <tr>
            <td>
                <form name="form1" action="" method="post">
                    <table border=1 width=100%>
                        <tr align="center">
                            <td width=10%><input type="checkbox" name="checkall"
                                                 onclick="javascript:selectAll(this.checked);"/></td>
                            <td width=30%>产品名称</td>
                            <td width=30%>产品产地</td>
                            <td>产品价格</td>

                        </tr>
                        <%
                            List<Product> list = (List<Product>) request.getAttribute("list");
                            if (list != null && !list.isEmpty()) {

                                for (Product p : list) {%>

                        <tr align="center">
                            <td width=10%><input type="checkbox" name="ids" value="<%=p.getId() %>"/></td>
                            <td width=30%><%=p.getName() %>
                            </td>
                            <td width=30%><%=p.getAddress() %>
                            </td>
                            <td><%=p.getPrice() %>
                            </td>

                                <%}


   			}else{%>

                        <tr align="center">
                            <td width=10%><input type="checkbox" name=""/></td>
                            <td width=30%></td>
                            <td width=30%></td>
                            <td></td>

                        </tr>
                        <%

                            }
                        %>

                    </table>
                </form>
            </td>

        </tr>

        <tr>
            <td>
                <button type="button" onclick="del()">删除</button><!--del()-->
                <button type="button" onclick="view()">查看</button><!--view()-->

            </td>
        </tr>

        <tr>
            <td colspan="4" align="center">
                共<%=request.getAttribute("maxpage")  %>页
                <a href="javascript:first();">首页</a>
                <a href="javascript:forward();">上一页</a>
                <%=request.getAttribute("bar")%>
                <a href="javascript:next();">下一页</a>
                <a href="javascript:end();">尾页</a>
                跳转到<select name="select" onchange="change(this.value)">

                <%
                    int pageCount = (Integer) request.getAttribute("maxpage");
                    System.out.println(pageCount);
                    if (pageCount > 0) {
                        for (int i = 1; i <= pageCount; i++) {%>

                <option value="<%=i %>" <%=((i == (Integer) request.getAttribute("currPage")) ? "selected" : "")%>><%=i %>
                </option>

                <%
                    }

                } else {// 无记录
                %>
                <option value="1">1</option>
                <%
                    }

                %>

            </select>

            </td>
        </tr>


    </table>


</div>


</body>
</html>
