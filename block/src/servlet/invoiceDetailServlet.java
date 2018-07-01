package servlet;

import entity.Invoice;
import entity.Task;
import service.invoiceService;
import service.taskService;

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

        String taskIDStr=request.getParameter("taskID");
        int TID=0;
        if(taskIDStr!=null&&!"".equals(taskIDStr))
            TID=Integer.parseInt(taskIDStr);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
