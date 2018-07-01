<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xixi
  Date: 2018/6/19
  Time: 上午11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>consultTask</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/consulttask/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="files/consulttask/data.js"></script>
    <script src="files/consulttask/consultTask.js"></script>
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

    <!-- Unnamed (Rectangle) -->
    <div id="u44" class="ax_default _默认样式">
        <div id="u44_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u45" class="text" style="display: none; visibility: hidden">
            <p><span></span></p>
        </div>
    </div>

    <!-- footer (Group) -->
    <div id="u46" class="ax_default" data-label="footer">

        <!-- Unnamed (Rectangle) -->
        <div id="u47" class="ax_default _默认样式">
            <img id="u47_img" class="img " src="images/consulttask/u47.png"/>
            <!-- Unnamed () -->
            <div id="u48" class="text" style="visibility: visible;">
                <p><span>Copyright © </span><a id="u49" class="link" title="点击打开www.AxureUX.com"><span>www.AxureUX.com</span></a><span>, All Rights Reserved.</span></p><p><span>Email : </span><a id="u50" class="link" title="点击发送邮件"><span>5698401@qq.com</span></a><span>&nbsp; QQ: 5698401</span></p>
            </div>
        </div>
    </div>

    <!-- 灰色背景 (Dynamic Panel) -->
    <div id="u51" class="ax_default" data-label="灰色背景">
        <div id="u51_state0" class="panel_state" data-label="State1">
            <div id="u51_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- Unnamed (顶部通栏) -->

    <!-- 灰色背景 (Dynamic Panel) -->
    <div id="u53" class="ax_default" data-label="灰色背景">
        <div id="u53_state0" class="panel_state" data-label="State1">
            <div id="u53_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- 线条 (Dynamic Panel) -->
    <div id="u54" class="ax_default" data-label="线条">
        <div id="u54_state0" class="panel_state" data-label="State1">
            <div id="u54_state0_content" class="panel_state_content">
            </div>
        </div>
    </div>

    <!-- 页面标题 (Rectangle) -->
    <div id="u55" class="ax_default _默认样式" data-label="页面标题">
        <div id="u55_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u56" class="text" style="display: none; visibility: hidden">
            <p><span></span></p>
        </div>
    </div>

    <form method="post" action="">
        <!-- Unnamed (Rectangle) -->
        <div id="u58" class="ax_default label">
            <div id="u58_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u59" class="text" style="visibility: visible;">
                <p><span>任务单号</span></p>
            </div>
        </div>
        <!-- Input field (Text Field)任务单号 -->
        <div id="u57" class="ax_default" data-label="Input field">
            <input id="u57_input" type="text" name="taskID" value=""/>
        </div>

        <!-- Input Message (Rectangle) -->
        <div id="u86" class="ax_default" data-label="Input Message">
            <div id="u86_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u87" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
            </div>
        </div>

        <!-- Date Field (日期) -->
        <div id="u88" class="ax_default" data-label="Date Field">
            <input id="u88_input" type="text" name="date" value=""/>
        </div>

        <!-- Unnamed (Image) -->
        <div id="u89" class="ax_default image">
            <img id="u89_img" class="img " src="images/consulttask/u89.png"/>
            <!-- Unnamed () -->
            <div id="u90" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
            </div>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u91" class="ax_default label">
            <div id="u91_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u92" class="text" style="visibility: visible;">
                <p><span>要求完成日期</span></p>
            </div>
        </div>

        <!-- Unnamed (Rectangle) -->
        <div id="u93" class="ax_default label">
            <div id="u93_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u94" class="text" style="visibility: visible;">
                <p><span>任务状态</span></p>
            </div>
        </div>

        <!-- Unnamed (Group) -->
        <div id="u97" class="ax_default">

            <!-- middle (Rectangle) -->
            <div id="u98" class="ax_default" data-label="middle">
                <div id="u98_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u99" class="text" style="display: none; visibility: hidden">
                    <p><span></span></p>
                </div>
            </div>

            <!-- Input Field Dropdown (Text Field) -->
            <div id="u100" class="ax_default text_field" data-label="Input Field Dropdown">
                <%--<input id="u100_input" type="text" value=""/>--%>
                <select name="state" id="u100_input">
                    <option value="5">分站到货</option>
                    <option value="6">已分配</option>
                    <option value="7">已领货</option>
                    <option value="8">已完成</option>
                </select>
            </div>


        </div>





        <!-- 任务类型 (Rectangle) -->
        <div id="u95" class="ax_default label">
            <div id="u95_div" class=""></div>
            <!-- Unnamed () -->
            <div id="u96" class="text" style="visibility: visible;">
                <p><span>任务类型</span></p>
            </div>
        </div>


        <!-- Unnamed (Group) -->
        <div id="u121" class="ax_default">

            <!-- middle (Rectangle) -->
            <div id="u122" class="ax_default" data-label="middle">
                <div id="u122_div" class=""></div>
                <!-- Unnamed () -->
                <div id="u123" class="text" style="display: none; visibility: hidden">
                    <p><span></span></p>
                </div>
            </div>

            <!-- Input Field Dropdown (Text Field) -->
            <div id="u124" class="ax_default text_field" data-label="Input Field Dropdown">
                <%--<input id="u124_input" type="text" value=""/>--%>
                <select name="type" id="u124_input">
                    <option value="0">退订</option>
                    <option value="1">新订</option>
                </select>
            </div>

            <!-- Unnamed (Group) -->

        </div>

        <!-- list -->
    <div id="data">
        <table >
            <tr>
                <th>任务单号</th>
                <th>要求完成日期</th>
                <th>任务类型</th>
                <th>任务状态</th>
            </tr>

        </table>
    </div>

    </form>














    <!-- Unnamed (Group) -->
    <div id="u204" class="ax_default">

        <!-- Unnamed (Right Arrow Button) -->
        <div id="u205" class="ax_default primary_button" onclick="submitConsult()">
            <img id="u205_img" class="img " src="images/consulttask/u205.png"/>
            <!-- Unnamed () -->
            <div id="u206" class="text" style="visibility: visible;">
                <p><span>查询</span></p>
            </div>
        </div>

        <!-- Unnamed (Shape) -->
        <div id="u207" class="ax_default icon">
            <img id="u207_img" class="img " src="images/consulttask/u207.png"/>
            <!-- Unnamed () -->
            <div id="u208" class="text" style="display: none; visibility: hidden">
                <p><span></span></p>
            </div>
        </div>
    </div>



</div>
</body>
</html>
