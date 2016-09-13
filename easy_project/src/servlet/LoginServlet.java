package servlet;

import DAO.UserDao;
import bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by jay chen on 2016/9/2.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();

        User u=new User();
        String username=request.getParameter("username");
        String pswd=request.getParameter("pswd");


        u.setName(username);
        u.setPswd(pswd);

        if(UserDao.login(u)){
            request.getSession().setAttribute("username",username);
            request.getSession().setAttribute("pswd",pswd);
            request.getRequestDispatcher("/DivideServlet").forward(request,response);
        }else{
            response.sendRedirect("pswderror.jsp");
        }
        out.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
