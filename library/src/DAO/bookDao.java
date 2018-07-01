package DAO;

import DBConnect.DBconnect;
import bean.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 31/05/2017.
 */
public class bookDao {
    public static List<Book> getBook(){
        List<Book> bk=new ArrayList<>();
        Connection conn= DBconnect.getConn();
        String sql="select * from book";

        try {
            Statement sm=conn.createStatement();
            ResultSet rs=sm.executeQuery(sql);
            while(rs.next()){
                Book book=new Book();
                book.setId(rs.getString(1));
                book.setName(rs.getString(2));
                book.setPrice(rs.getDouble(3));
                book.setImage(rs.getString(4));

                bk.add(book);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bk;
    }
}
