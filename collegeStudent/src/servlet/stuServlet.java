package servlet;

import bean.Student;
import dao.stuAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay chen on 2016/9/17.
 */
@WebServlet(name = "stuServlet",urlPatterns = "/stuServlet")
public class stuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action=request.getParameter("action");
        Student stu=new Student();
        List<Student> list=new ArrayList<Student>();
        boolean flag=false;

        switch (action){
            case "publish":
                //String name=request.getParameter("name");
                stu.setName(request.getParameter("name"));
                stu.setAge(request.getParameter("age"));
                stu.setGender(request.getParameter("gender"));
                stu.setGrade(request.getParameter("grade"));
                stu.setSubject(request.getParameter("subject"));
                stu.setAddress(request.getParameter("address"));
                stu.setTime(request.getParameter("time"));
                stu.setEmail(request.getParameter("email"));

                flag= stuAction.publish(stu);
                break;
            case "search":
                //暂不分页
                list=stuAction.search();
                if(list!=null){
                    flag=true;
                }
                break;
            case "view":
                String id=request.getParameter("id");
                stu=stuAction.view(id);
                if(stu!=null){
                    flag=true;
                }
                break;
        }

        if(flag){
            switch (action){
                case "publish":
                    response.sendRedirect("index.jsp");
                    break;
                case "search":
                    request.setAttribute("list",list);
                    request.getRequestDispatcher("Module_practice/briefMessage.jsp").forward(request,response);
                    break;
                case "view":
                    request.setAttribute("student",stu);
                    request.getRequestDispatcher("Module_practice/studentMessage.jsp").forward(request,response);
                    break;
            }
        }else{
            switch (action){
                case "publish":
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                    break;
                case "search":
                    System.out.println("查看列表失败");
                    response.sendRedirect("index.jsp");
                    break;
                case "view":
                    System.out.println("查看学生详细信息失败");
                    response.sendRedirect("index.jsp");

            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
