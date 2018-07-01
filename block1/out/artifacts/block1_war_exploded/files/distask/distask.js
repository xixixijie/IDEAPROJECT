/**
 * Created by xixi on 2018/6/19.
 */
function submitConsult() {

    document.forms[0].action="consultTaskServlet?action=2";
    document.forms[0].submit();
}
var req;
function submitCourier(taskID,selectID) {
    //alert(taskID+" "+selectID);
    var courier=document.getElementById(selectID);
    //alert(courier.value);
    var courierID=courier.value;
    //alert(courierID);
   if(window.XMLHttpRequest){
       req=new XMLHttpRequest();
   }else if(window.ActiveXObject){
       req=new ActiveXObject("Microsoft.XMLHTTP");
   }

   req.open("post","disCourierServlet",false);
   req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
   req.onreadystatechange=function () {
       disCourier(selectID);
   };
   req.send("taskID="+taskID+"&courierID="+courierID );

}

function disCourier(selectID) {
    //alert(selectID);
    var text=document.getElementById("back"+selectID);
    text.innerText="修改成功";
}