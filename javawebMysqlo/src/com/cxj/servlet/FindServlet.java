package com.cxj.servlet;

import com.cxj.bean.Book;
import common.Conn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay chen on 2016/8/26.
 */
@WebServlet(name = "FindServlet",urlPatterns = "/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn=Conn.getConn();
        try {
            Statement stmt=conn.createStatement();
            String sql="select * from tb_books";
            ResultSet rs=stmt.executeQuery(sql);
            List<Book> list=new ArrayList<>();

            while (rs.next()){
                Book book=new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setBookCount(rs.getInt("bookCount"));
                book.setAuthor(rs.getString("author"));
                list.add(book);
            }
            request.setAttribute("list",list);
            Conn.closeConn(conn,stmt,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //转发到另个页面 不影响request&response
        request.getRequestDispatcher("book_list.jsp").forward(request,response);
    }
}
