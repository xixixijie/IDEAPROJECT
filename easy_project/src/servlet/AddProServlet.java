package servlet;

import DAO.ProDao;
import bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jay chen on 2016/9/2.
 */
@WebServlet(name = "AddProServlet",urlPatterns = "/AddProServlet")
public class AddProServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Product p=new Product();
        p.setName(request.getParameter("name"));
        p.setPrice(request.getParameter("price"));
        p.setAddress(request.getParameter("address"));
        p.setImage(request.getParameter("image"));

        if(ProDao.addToDB(p)){
            //加入成功
            System.out.println("成功");
        }else{
            //加入失败
            System.out.println("失败");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
