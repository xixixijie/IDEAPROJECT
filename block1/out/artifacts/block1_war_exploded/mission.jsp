<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2018/6/19
  Time: 上午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<html>
<head>
    <title>详细任务单</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/dis/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="files/dis/data.js"></script>
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
    <div id="u1109" class="ax_default" data-label="footer">

        <!-- Unnamed (Rectangle) -->
        <div id="u1110" class="ax_default _默认样式">
            <img id="u1110_img" class="img " src="images/consulttask/u47.png"/>
            <!-- Unnamed () -->
            <div id="u1111" class="text" style="visibility: visible;">
                <p><span>Copyright © </span><a id="u1112" class="link" title="点击打开www.AxureUX.com"><span>www.AxureUX.com</span></a><span>, All Rights Reserved.</span></p><p><span>Email : </span><a id="u1113" class="link" title="点击发送邮件"><span>5698401@qq.com</span></a><span>&nbsp; QQ: 5698401</span></p>
            </div>
        </div>
    </div>

    <!-- 灰色背景 (Dynamic Panel) -->
    <div id="u1114" class="ax_default" data-label="灰色背景">
        <div id="u1114_state0" class="panel_state" data-label="State1">
            <div id="u1114_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- Unnamed (顶部通栏) -->

    <!-- 灰色背景 (Dynamic Panel) -->
    <div id="u1116" class="ax_default" data-label="灰色背景">
        <div id="u1116_state0" class="panel_state" data-label="State1">
            <div id="u1116_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- 线条 (Dynamic Panel) -->
    <div id="u1117" class="ax_default" data-label="线条">
        <div id="u1117_state0" class="panel_state" data-label="State1">
            <div id="u1117_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- 页面标题 (Rectangle) -->
    <div id="u1118" class="ax_default _默认样式" data-label="页面标题">
        <div id="u1118_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u1119" class="text" style="display: none; visibility: hidden">
            <p><span></span></p>
        </div>
    </div>


    <br>
    <br>
    <div>
        <h1>详细任务单</h1>
    </div>
    <div name="data">
        <form action="" method="post">
            <table>
                <tr>
                    <td>任务单号</td>
                    <td>${data.missionID}</td>
                </tr>
                <%--<tr>--%>
                <%--<td>客户姓名</td>--%>
                <%--<td>${data.orderInfo.user.userName}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>联系电话</td>--%>
                <%--<td>${data.orderInfo.user.telephone}</td>--%>
                <%--</tr>--%>
                <tr>
                    <td>任务类型</td>
                    <td>${data.type}</td>
                </tr>
                <tr>
                    <td>任务状态</td>
                    <td>${data.state}</td>
                </tr>
                <%--<tr>--%>
                <%--<td>是否要发票</td>--%>
                <%--<td>${data.orderInfo.billNeed}</td>--%>
                <%--</tr>--%>

                <tr>
                    <td>配送员</td>
                    <td>
                        <select name="courier" id="u385_input">
                            <c:if test="${data.courier.name!=''}">
                                <option value="${data.courier.CID}">${data.courier.name}</option>
                            </c:if>
                            <c:if test="${data.courier.name==''}">
                                <option value="0">未分配</option>

                            </c:if>
                            <c:forEach items="${couriers}" var="c">
                                <c:if test="${c.CID!=data.courier.CID}">
                                    <option value="${c.CID}">${c.name}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>要求完成日期</td>
                    <td>${data.orderInfo.requiredDate}</td>
                </tr>
                <%--<tr>--%>
                <%--<td>商品名</td>--%>
                <%--<td>${data.orderInfo.good.name}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>订购数量</td>--%>
                <%--<td>${data.orderInfo.amount}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>总金额</td>--%>
                <%--<td>${data.orderInfo.totalMoney}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>收货人信息</td>--%>
                <%--<td>${data.orderInfo.name}</td>--%>

                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>收货人地址</td>--%>
                <%--<td>${data.orderInfo.receiverAddress}</td>--%>
                <%--</tr>--%>

                <%--<tr>--%>
                <%--<td>收货人移动电话</td>--%>
                <%--<td>${data.orderInfo.receiverTelephone}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>付款人姓名</td>--%>
                <%--<td>${data.orderInfo.payerName}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>付款人地址</td>--%>
                <%--<td>${data.orderInfo.payerAddress}</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>付款人移动电话</td>--%>
                <%--<td>${data.orderInfo.payerTelephone}</td>--%>
                <%--</tr>--%>

                <%--<tr>--%>
                <%--<td>订单状态</td>--%>
                <%--<td>${data.orderInfo.status}</td>--%>
                <%--</tr>--%>
            </table>
        </form>

    </div>

    <div>
        <button type="button" onclick="">提交修改</button>

    </div>
</div>
</body>
</html>
