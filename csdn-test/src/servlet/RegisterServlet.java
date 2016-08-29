package servlet;

import Bean.User;
import DAO.RegisterDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jay chen on 2016/8/28.
 */

public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name=request.getParameter("name");
        String age=request.getParameter("age");
        String sex=request.getParameter("sex");
        String studentID=request.getParameter("StudentID");
        String phone=request.getParameter("phone");
        String academy=request.getParameter("academy");
        String major=request.getParameter("major");
        User user=new User();
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setStudentID(studentID);
        user.setPhone(phone);
        user.setAcademy(academy);
        user.setMajor(major);

        if(RegisterDAO.Register(user)==true){
            //注册成功
            System.out.print("注册成功");
        }else {
            //注册失败
            System.out.print("注册失败");

        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
