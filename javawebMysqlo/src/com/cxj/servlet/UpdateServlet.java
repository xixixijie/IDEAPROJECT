package com.cxj.servlet;

import common.Conn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by jay chen on 2016/8/26.
 */
@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        int bookCount=Integer.valueOf(request.getParameter("bookCount"));

        Connection conn=Conn.getConn();
        String sql="update tb_books set bookCount=? where id=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,bookCount);
            ps.setInt(2,id);
            ps.executeUpdate();

            Conn.closeConn(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //因为已经修改所以不需要request里的数据
        response.sendRedirect("FindServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
