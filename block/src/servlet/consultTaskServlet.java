package servlet;

import entity.Task;
import service.taskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class consultTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String taskIDStr=request.getParameter("taskID");
        String dateStr=request.getParameter("date");
        String typeStr=request.getParameter("type");
        String stateStr=request.getParameter("state");
        String courierName=request.getParameter("name");
        Date date=null;
        int TID=0;
        int type=0;
        int state=0;
        System.out.println(taskIDStr+" "+dateStr+" "+typeStr+" "+stateStr);
        //处理Str
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
        try {
            if(dateStr!=null&&!"".equals(dateStr))
                 date=sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(taskIDStr!=null&&!"".equals(taskIDStr))
            TID=Integer.parseInt(taskIDStr);
        if(typeStr!=null&&!"".equals(typeStr))
            type=Integer.parseInt(typeStr);
        if(stateStr!=null&&!"".equals(stateStr))
            state=Integer.parseInt(stateStr);


        List<Task> list=taskService.getService().consultTasks(TID,date,type,state,courierName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
