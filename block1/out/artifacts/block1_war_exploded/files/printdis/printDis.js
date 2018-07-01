/**
 * Created by xixi on 2018/6/20.
 */
function submitConsult() {

    document.forms[0].action="consultTaskServlet?action=3";
    document.forms[0].submit();
}

function printDis() {
    var chks=document.getElementsByName("chk");
    var flag=false;
    for(var i=0;i<chks.length;i++){
        if(chks[i].checked == true ){
            //alert(chks[i].value);
            flag=true;
            break;
        }
    }
    if(flag) {
        document.forms[1].action = "printDisServlet";
        document.forms[1].submit();
    }else{
        alert("请至少选一个打印单");
    }
}