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
@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out=response.getWriter();
        out.println("<html>\n" +
                "  <head>\n" +
                "    <title>MyServlet</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                this.getClass() +
                "  </body>\n" +
                "</html>");
    }
}
