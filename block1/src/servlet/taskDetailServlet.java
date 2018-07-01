package servlet;

import entity.Courier;
import entity.MissionList;
import service.courierService;
import service.taskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class taskDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String taskIDStr=request.getParameter("taskID");
        System.out.println(taskIDStr);
        int TID=0;
        if(taskIDStr!=null&&!"".equals(taskIDStr))
            TID=Integer.parseInt(taskIDStr);

        List<Courier> courierList= courierService.getService().getCouriers();

        System.out.println("配送员数量"+courierList.size());
        for(Courier c:courierList){
            System.out.println(c.getCID()+" :"+c.getName());
        }
        MissionList task=taskService.getService().consultDetail(TID);
        task.switchInt();
        request.setAttribute("data",task);
        request.setAttribute("couriers",courierList);
        System.out.println(task.getMissionID());
        request.getRequestDispatcher("mission.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
