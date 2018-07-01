package Servlet;

import DAO.userDao;
import bean.User;

import java.io.IOException;

/**
 * Created by xixi on 31/05/2017.
 */
@javax.servlet.annotation.WebServlet(name = "userServlet",urlPatterns="/userServlet")
public class userServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        User user=new User();
        String action=request.getParameter("action");
        boolean flag=false;
        switch (action){
            case "register":
                user.setId(request.getParameter("id"));
                user.setBkId(request.getParameter("id")+"_bk");
                user.setMoney(0);
                user.setPwd(request.getParameter("pwd"));
                flag=userDao.add(user);
                if(flag){
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
                break;
            case "login":
                user.setId(request.getParameter("id"));
                user.setPwd(request.getParameter("pwd"));
                User user1=userDao.check(user);
                if(!user1.getPwd().equals(user.getPwd())){
                    System.out.println("密码错误");
                }else {
                    request.setAttribute("user",user1);
                    request.getRequestDispatcher("iframe.jsp").forward(request,response);
                }
                break;
            case "get":
                user.setId(request.getParameter("id"));
                User user2=userDao.check(user);
                request.setAttribute("user",user2);
                request.getRequestDispatcher("mybk.jsp").forward(request,response);
                break;
            case "addMoney":
                double money=Double.parseDouble(request.getParameter("money"));
                user.setId(request.getParameter("id"));

                userDao.addMoney(user,money);

                User user3=userDao.check(user);

                request.setAttribute("user",user3);
                request.getRequestDispatcher("mybk.jsp").forward(request,response);

        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
