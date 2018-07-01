package Servlet;

import DAO.bookDao;
import bean.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by xixi on 01/06/2017.
 */
@WebServlet(name = "bkServlet",urlPatterns ="bkServlet")
public class bkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookCase= bookDao.getBook();
        request.setAttribute("bookcase",bookCase);
        request.getRequestDispatcher("library.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
