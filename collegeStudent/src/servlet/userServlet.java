package servlet;

import Entity.UserEntity;
import dao.userAction;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

/**
 * Created by jay chen on 2016/9/14.
 */
@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class userServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String url=request.getParameter("url");

        String action=request.getParameter("action");
        UserEntity u=new UserEntity();
        boolean flag=false;

        switch(action){
            case "login":
                u.setId( request.getParameter("id"));
                u.setPwd(request.getParameter("pwd"));
                flag=userAction.login(u);
                break;
            case "register":
                u.setId( request.getParameter("id"));
                u.setName(request.getParameter("name"));
                u.setPwd(request.getParameter("pwd"));
                u.setUniversity(request.getParameter("university"));
                u.setCollege(request.getParameter("college"));
                u.setMajor(request.getParameter("major"));
                u.setGrade( request.getParameter("grade"));
                u.setGender(request.getParameter("gender"));
                u.setEmail( request.getParameter("email"));
                flag=userAction.register(u);
                break;
            case "logout":
                flag=true;
        }

        if(flag){
            switch(action){
                case "login":
                    request.getSession().setAttribute("user",u);
                    System.out.printf(u.getName()+u.getId());
                    response.sendRedirect(url);
                    break;
                case "register":
                    request.getSession().setAttribute("user",u);
                    response.sendRedirect("index.jsp");
                    break;
                case "logout":
                    request.getSession().removeAttribute("user");
                    response.sendRedirect(url);


            }

        }else{
            switch (action){
                case "login":
                    request.setAttribute("error","pwd");
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                    break;
                case "register":
                    System.out.println(u.getName()+"注册失败");
                    response.sendRedirect("index.jsp");
                    break;

            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
