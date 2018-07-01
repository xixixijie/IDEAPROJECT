package servlet;

import entity.Invoice;
import service.invoiceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class consultInvoiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String taskIDStr=request.getParameter("taskID");
        String invoiceIDStr=request.getParameter("invoiceID");
        int TID=0;
        int IID=0;
        if(taskIDStr!=null&&!"".equals(taskIDStr))
            TID=Integer.parseInt(taskIDStr);
        if(invoiceIDStr!=null&&!"".equals(invoiceIDStr))
            IID=Integer.parseInt(invoiceIDStr);

        List<Invoice> list= invoiceService.getService().consultInvoices(TID,IID);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
