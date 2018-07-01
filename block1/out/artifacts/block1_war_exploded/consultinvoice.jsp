<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2018/6/19
  Time: 上午11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <title>consultInvoice</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/consultinvoice/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/axure/axQuery.js"></script>
    <script src="resources/scripts/axure/globals.js"></script>
    <script src="resources/scripts/axutils.js"></script>
    <script src="resources/scripts/axure/annotation.js"></script>
    <script src="resources/scripts/axure/axQuery.std.js"></script>
    <script src="resources/scripts/axure/doc.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/messagecenter.js"></script>
    <script src="resources/scripts/axure/events.js"></script>
    <script src="resources/scripts/axure/recording.js"></script>
    <script src="resources/scripts/axure/action.js"></script>
    <script src="resources/scripts/axure/expr.js"></script>
    <script src="resources/scripts/axure/geometry.js"></script>
    <script src="resources/scripts/axure/flyout.js"></script>
    <script src="resources/scripts/axure/ie.js"></script>
    <script src="resources/scripts/axure/model.js"></script>
    <script src="resources/scripts/axure/repeater.js"></script>
    <script src="resources/scripts/axure/sto.js"></script>
    <script src="resources/scripts/axure/utils.temp.js"></script>
    <script src="resources/scripts/axure/variables.js"></script>
    <script src="resources/scripts/axure/drag.js"></script>
    <script src="resources/scripts/axure/move.js"></script>
    <script src="resources/scripts/axure/visibility.js"></script>
    <script src="resources/scripts/axure/style.js"></script>
    <script src="resources/scripts/axure/adaptive.js"></script>
    <script src="resources/scripts/axure/tree.js"></script>
    <script src="resources/scripts/axure/init.temp.js"></script>
    <script src="files/consultinvoice/data.js"></script>
    <script src="files/consultinvoice/consultinvoice.js"></script>

    <script src="resources/scripts/axure/legacy.js"></script>
    <script src="resources/scripts/axure/viewer.js"></script>
    <script src="resources/scripts/axure/math.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
</head>
<body>
<div id="base" class="">



    <!-- footer (Group) -->
    <div id="u1391" class="ax_default" data-label="footer">

        <!-- Unnamed (Rectangle) -->
        <div id="u1392" class="ax_default _默认样式">
            <img id="u1392_img" class="img " src="images/consulttask/u47.png"/>
            <!-- Unnamed () -->
            <div id="u1393" class="text" style="visibility: visible;">
                <p><span>Copyright © </span><a id="u1394" class="link" title="点击打开www.AxureUX.com"><span>www.AxureUX.com</span></a><span>, All Rights Reserved.</span></p><p><span>Email : </span><a id="u1395" class="link" title="点击发送邮件"><span>5698401@qq.com</span></a><span>&nbsp; QQ: 5698401</span></p>
            </div>
        </div>
    </div>

    <!-- 灰色背景 (Dynamic Panel) -->
    <div id="u1396" class="ax_default" data-label="灰色背景">
        <div id="u1396_state0" class="panel_state" data-label="State1">
            <div id="u1396_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- Unnamed (顶部通栏) -->

    <!-- 灰色背景 (Dynamic Panel) -->
    <div id="u1398" class="ax_default" data-label="灰色背景">
        <div id="u1398_state0" class="panel_state" data-label="State1">
            <div id="u1398_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- 线条 (Dynamic Panel) -->
    <div id="u1399" class="ax_default" data-label="线条">
        <div id="u1399_state0" class="panel_state" data-label="State1">
            <div id="u1399_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- 页面标题 (Rectangle) -->
    <div id="u1400" class="ax_default _默认样式" data-label="页面标题">
        <div id="u1400_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u1401" class="text" style="display: none; visibility: hidden">
            <p><span></span></p>
        </div>
    </div>
    <form action="" method="post">
        <!-- Input field (Text Field) -->
        <div id="u1402" class="ax_default" data-label="Input field">
            <input id="u1402_input" type="text" name="taskID" value=""/>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u1403" class="ax_default label">
            <div id="u1403_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u1404" class="text" style="visibility: visible;">
                <p><span>任务单号</span></p>
            </div>
        </div>

        <!-- Input field (Text Field) -->
        <div id="u1456" class="ax_default" data-label="Input field">
            <input id="u1456_input" type="text" name="invoiceID" value=""/>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u1457" class="ax_default label">
            <div id="u1457_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u1458" class="text" style="visibility: visible;">
                <p><span style="font-family:'ArialMT', 'Arial';">发票</span><span style="font-family:'PingFangSC-Regular', 'PingFang SC';">号</span></p>
            </div>
        </div>
    </form>

    <!-- Unnamed (Right Arrow Button) -->
    <div id="u1461" class="ax_default primary_button" onclick="submitConsult()">
        <img id="u1461_img" class="img " src="images/consulttask/u205.png"/>
        <!-- Unnamed () -->
        <div id="u1462" class="text" style="visibility: visible;">
            <p><span>查询</span></p>
        </div>
    </div>

    <br>
    <br><br><br><br><br><br><br><br>
    <div id="data">
        <table >
            <tr>
                <th>任务单号</th>
                <th>发票号</th>
                <th>发票状态</th>
            </tr>
            <c:forEach items="${datalist}" var="data">
                <div name="data">

                    <tr>
                        <td>
                            <a href="taskDetailServlet?taskID=${data.missionID}" target="_blank">
                                    ${data.missionID}
                            </a>
                        </td>
                        <td><a href="invoiceDetailServlet?invoiceID=${data.invoiceID}" target="_blank">${data.invoiceID}</a></td>
                        <td>${data.stateStr}</td>

                    </tr>


                </div>
            </c:forEach>
        </table>
    </div>

    <!--页数-->
    <center>
        <div>
            <ul>

                <c:forEach begin="1" end="${pagecount}" var="p">
                    <c:if test="${p==pagenum}">
                        <input id="pageNum" value="${pagenum}" type="hidden">
                        <li><a>${p}</a></li>
                    </c:if>
                    <c:if test="${p!=pagenum}">
                        <li><a href="consultInvoiceServlet?action=1&pagenum=${p}">${p}</a> </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </center>
</div>
</body>
</html>
