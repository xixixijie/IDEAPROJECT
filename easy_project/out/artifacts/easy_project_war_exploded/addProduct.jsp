<%--
  Created by IntelliJ IDEA.
  User: jay chen
  Date: 2016/9/3
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>加入商品</title>
    <script language="javascript">
        function check() {
            var file=document.getElementById("proimage").files[0];

            if(form1.proname.value==""){
                alert("请输入产品名称");
                form1.proname.focus();
            }else if(form1.proprice.value==""){
                alert("请输入产品价格");
                form1.proprice.focus();
            }else if(form1.proaddress.value==""){
                alert("请输入产品产地");
                form1.proaddress.focus();
            }else if(form1.proimage.value==""){
                alert("请选择文件");
                form1.proimage.focus();
            }else if((file.type).indexOf("image/")==-1){
                alert("请选择图片文件");
                form1.proiamge.focus();
            }else{
                form1.action="AddProServlet";
                form1.submit();
            }

        }


    </script>
</head>
<body>
<div align="center">

    <table width=70% style="margin:auto;">
        <tr><td align="center" height=150 valign="bottom">产品信息添加</td></tr>
        <tr>
            <td>
                <form id="form1" name="form1" action="" method="post" enctype="multipart/form-data">
                    <table border=1 style="margin:auto">
                        <tr >
                            <td>产品名称</td>
                            <td><input type="text" name="proname" id="proname"/></td>
                            <td>产品价格</td>
                            <td><input type="text" name="proprice" id="proprice"/></td>
                        </tr>
                        <tr>
                            <td>产品产地</td>
                            <td colspan="3"><input type="text" name="proaddress" id="proaddress"/></td>
                        </tr>
                        <tr>
                            <td>产品图片</td>
                            <td colspan="3"><input type="file" name="proimage" id="proimage"  size=35/></td>
                        </tr>

                    </table>
                </form>

            </td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <button type="button" onclick="check()">确定</button>
                <button type="button" onclick="javascript:location.href='DivideServlet'">返回</button>

            </td>
        </tr>

    </table>

</div>
</body>

</body>
</html>
