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
 * Created by jay chen on 2016/9/5.
 */
@WebServlet(name = "ViewServlet",urlPatterns = "/ViewServlet")
public class ViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String proid=request.getParameter("proid");

        Product p= ProDao.viewPro(proid);



        request.setAttribute("product",p);
        request.getRequestDispatcher("viewProduct.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
