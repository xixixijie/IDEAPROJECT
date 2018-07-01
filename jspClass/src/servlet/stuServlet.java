package servlet;

import bean.Student;
import dao.stuAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 22/04/2017.
 */
@javax.servlet.annotation.WebServlet(name = "stuServlet", urlPatterns = "/stuServlet")
public class stuServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        Student stu = new Student();
        boolean flag = false;
        switch (action) {
            case "register":
                stu.setId(request.getParameter("studentNumber"));
                stu.setPwd(request.getParameter("password"));
                stu.setAcademy(request.getParameter("college"));
                stu.setMajor(request.getParameter("major"));
                stu.setName(request.getParameter("name"));
                stu.setSex(request.getParameter("gender"));
                if (stuAction.addToDB(stu)) {
                    //加入成功 页面跳转

                } else {
                    //加入失败

                    request.setAttribute("error", "用户名已被注册");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
                break;
            case "modify":

                stu.setId(request.getParameter("studentNumber"));
                stu.setPwd(request.getParameter("password"));
                stu.setAcademy(request.getParameter("college"));
                stu.setMajor(request.getParameter("major"));
                stu.setName(request.getParameter("name"));
                stu.setSex(request.getParameter("gender"));
                if (stuAction.change(stu)) {
                    //修改成功
                } else {
                    //修改失败 跳转

                }
                break;
            case "login":
                System.out.println(action);
                System.out.println(request.getParameter("username")+":"+request.getParameter("password"));
                stu = stuAction.selectFromDB(request.getParameter("username"));
                if (stu == null) {
                    System.out.println("用户不存在");
                    request.setAttribute("error1", "用户不存在");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    if (request.getParameter("password") == stu.getPwd()) {
                        //登陆成功 跳转等操作

                    } else {
                        //登陆失败 密码不存在
                        request.setAttribute("error2", "密码错误");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                }
                break;
            case "divide":
                List<Student> list = stuAction.selectAll();
                if (request.getParameter("page") != null) {
                    request.setAttribute("page", request.getParameter("page"));
                } else {
                    request.setAttribute("page", 1);
                }
                request.setAttribute("list", list);
                request.getRequestDispatcher("page.jsp").forward(request, response);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
