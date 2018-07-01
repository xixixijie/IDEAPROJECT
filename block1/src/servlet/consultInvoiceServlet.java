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

        String pagenum=request.getParameter("pagenum");
        String taskIDStr;
        String invoiceIDStr;
        int pageNum=1;
        if(pagenum!=null&&!"".equals(pagenum)){
            //从session get
            taskIDStr= (String) request.getSession().getAttribute("taskID");
            invoiceIDStr= (String) request.getSession().getAttribute("invoiceID");
            pageNum=Integer.parseInt(pagenum);
        }else{
            taskIDStr=request.getParameter("taskID");
            invoiceIDStr=request.getParameter("invoiceID");
        }


        int TID=0;
        int IID=0;
        int pageSize=5;


        System.out.println(taskIDStr+" "+invoiceIDStr);
        if(taskIDStr!=null&&!"Search".equals(taskIDStr))
            TID=Integer.parseInt(taskIDStr);
        if(invoiceIDStr!=null&&!"Search".equals(invoiceIDStr))
            IID=Integer.parseInt(invoiceIDStr);

        List<Invoice> list= invoiceService.getService().consultInvoices(TID,IID,pageSize,pageNum);

        for(Invoice i:list){
            i.switchInt();
        }
        System.out.println("返回发票数据大小"+list.size());
        int pageCount=invoiceService.getService().selectCount(TID,IID,pageSize);
        request.setAttribute("datalist",list);
        request.getSession().setAttribute("taskID",taskIDStr);
        request.getSession().setAttribute("invoiceID",invoiceIDStr);
        request.getSession().setAttribute("pagenum",pageNum);
        request.getSession().setAttribute("pagecount",pageCount);

        request.getRequestDispatcher("consultinvoice.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
