/**
 * Created by xixi on 2018/6/20.
 */
function submitConsult() {
    document.forms[0].action="consultTaskServlet?action=4";
    document.forms[0].submit();
}

function writeReceipt(taskID) {
    //alert(taskID);
    //alert("开始录入");
    //openScrollbarWin("writeReceipt.jsp?rtID="+taskID,"录入回执",400,400)


}


/*
 * 打开新窗口
 * f:链接地址
 * n:窗口的名称
 * w:窗口的宽度
 * h:窗口的高度
 */

function openScrollbarWin(f,n,w,h){
    var l = (screen.width - w)/2;
    var t = (screen.height - h)/2;
    var sFeatures = "left="+ l +",top="+ t +",height="+ h +",width="+ w
        + ",center=1,scrollbars=yes,status=0,resizable=yes,directories=0,channelmode=0";
    var openwin = window.open(f , n , sFeatures );
    if (!openwin.opener)
        openwin.opener = self;
    openwin.focus();
    return openwin;
}
