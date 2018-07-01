package servlet;

import service.invoiceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xixi on 2018/6/15.
 */
public class invoiceDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String invoiceIDStr=request.getParameter("invoiceID");
        int IID=0;
        if(invoiceIDStr!=null&&!"".equals(invoiceIDStr))
            IID=Integer.parseInt(invoiceIDStr);

        invoiceService.getService().consultDetail(IID);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
