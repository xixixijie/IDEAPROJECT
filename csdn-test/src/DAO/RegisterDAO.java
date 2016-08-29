package DAO;

import Bean.User;
import Conn.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jay chen on 2016/8/28.
 */
public class RegisterDAO {
    public static Boolean Register(User user){
        Connection conn= DBconnect.getConn();
        String sql="insert into student(SID,name,age,sex,phone,academy,major,date) values(?,?,?,?,?,?,?,?)";
        int judge = 0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String date = format.format(new Date());

            ps.setString(1, user.getStudentID());
            ps.setString(2, user.getName());
            ps.setString(3,user.getAge());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getPhone());
            ps.setString(6, user.getAcademy());
            ps.setString(7, user.getMajor());
            ps.setString(8, date);

            judge=ps.executeUpdate();
            DBconnect.closeConn(conn,ps);



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(judge!=0){
            return true;
        }else{
            return false;
        }

    }
}
