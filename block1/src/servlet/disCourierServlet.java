package servlet;

import entity.Administrator;
import service.taskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xixi on 2018/6/15.
 */
public class disCourierServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String taskIDStr=request.getParameter("taskID");
        String courierIDStr=request.getParameter("courierID");

        Administrator administrator=new Administrator();


        System.out.println(taskIDStr+" "+courierIDStr);

        int TID=0;
        int CID=0;

        if(taskIDStr!=null&&!"".equals(taskIDStr))
            TID=Integer.parseInt(taskIDStr);
        if(courierIDStr!=null&&!"".equals(courierIDStr))
            CID=Integer.parseInt(courierIDStr);

        taskService.getService().disCourier(TID,CID,administrator);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
