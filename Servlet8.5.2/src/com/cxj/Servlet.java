package com.cxj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jay chen on 2016/8/23.
 */
@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//解决中文乱码问题
        String name=request.getParameter("name");
        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out =response.getWriter();
        out.println("<html>\n" +
                "  <head>\n" +
                "    <title>$Title$</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "你输入的商品名为"+name+
                "  </body>\n" +
                "</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
