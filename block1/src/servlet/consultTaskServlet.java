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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class consultTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //System.out.println("in");
        String action = request.getParameter("action");
        //System.out.println(action);
        if (action.equals("5")) {
            consultBy3Con(request, response);
        } else {
            consultBy5Con(request, response, action);
        }
    }

    private void consultBy3Con(HttpServletRequest request, HttpServletResponse response) {
        String beginDate = request.getParameter("beginDate");
        String endDate = request.getParameter("endDate");
        String goodName = request.getParameter("goodName");

        System.out.println(beginDate + " " + endDate + " " + goodName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        Date begin = null, end = null;
        try {
            if (beginDate != null && !"YYYY/MM/DD".equals(beginDate))
                begin = sdf.parse(beginDate);
            if (endDate != null && !"YYYY/MM/DD".equals(endDate))
                end = sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<MissionList> list = taskService.getService().consultTasks(begin, end, goodName);


        request.setAttribute("date", list);
        try {
            request.getRequestDispatcher("consultTask.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void consultBy5Con(HttpServletRequest request, HttpServletResponse response, String action) {

        String pagenum=request.getParameter("pagenum");
        int pageSize=5;

        int pageNum=1;

        String taskIDStr;
        String dateStr ;
        String typeStr ;
        String stateStr ;
        String courierName;
        //根据日期查询还没做
        Date date=null;
        if(pagenum!=null&&!"".equals(pagenum)){
            pageNum=Integer.parseInt(pagenum);
            taskIDStr = (String) request.getSession().getAttribute("taskID");
            dateStr = (String) request.getSession().getAttribute("date");
            typeStr = (String)request.getSession().getAttribute("type");
            stateStr = (String)request.getSession().getAttribute("state");
            courierName = (String)request.getSession().getAttribute("name");
        }else{
            taskIDStr = request.getParameter("taskID");
            dateStr = request.getParameter("date");
            typeStr = request.getParameter("type");
            stateStr = request.getParameter("state");
            courierName = request.getParameter("name");
           date = null;
        }


        int TID = 0;
        int type = -1;
        int state = -1;
       // System.out.println(taskIDStr + " " + dateStr + " " + typeStr + " " + stateStr + " " + courierName);
        //处理Str
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
        try {
            if (dateStr != null && !"YYYY/MM/DD".equals(dateStr))
                date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (taskIDStr != null && !"Search".equals(taskIDStr))
            TID = Integer.parseInt(taskIDStr);
        if (typeStr != null && !"Search".equals(typeStr))
            type = Integer.parseInt(typeStr);
        if (stateStr != null && !"Search".equals(stateStr))
            state = Integer.parseInt(stateStr);


        List<MissionList> list = taskService.getService().consultTasks(TID, date, type, state, courierName,pageSize,pageNum);

        for (MissionList m : list) {
            m.switchInt();
        }
        int pageCount=taskService.getService().selectCount(TID, date, type, state, courierName,pageSize);
        System.out.println("查询任务单返回数据大小"+list.size());
        request.setAttribute("datalist", list);
        request.setAttribute("pagecount",pageCount);
        request.getSession().setAttribute("taskID",taskIDStr);
        request.getSession().setAttribute("date",dateStr);
        request.getSession().setAttribute("type",typeStr);
        request.getSession().setAttribute("state",stateStr);
        request.getSession().setAttribute("name",courierName);
        request.setAttribute("pagenum",pagenum);
        try {
            switch (action) {
                case "1":
                    request.getRequestDispatcher("consultTask.jsp").forward(request, response);
                    break;
                case "2":
                    List<Courier> couriers= courierService.getService().getCouriers();
                    request.setAttribute("couriers",couriers);
                    request.getRequestDispatcher("distask.jsp").forward(request, response);
                    break;
                case "3":
                    request.getRequestDispatcher("printdis.jsp").forward(request, response);

                    break;
                case "4":
                    request.getRequestDispatcher("receipt.jsp").forward(request, response);

                    break;
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
