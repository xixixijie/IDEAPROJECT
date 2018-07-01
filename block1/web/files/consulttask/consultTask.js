/**
 * Created by xixi on 2018/6/19.
 */
function submitConsult() {

    document.forms[0].action="consultTaskServlet?action=1";
    document.forms[0].submit();
}