package DAO;

import DBconnect.DBconnect;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jay chen on 2016/9/2.
 */
public class UserDao {
    public static boolean login(User u){
        Connection conn=DBconnect.getConn();
        String sql="select * from userinfo where username=? and pswd=?";
        boolean flag=false;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,u.getName());
            ps.setString(2,u.getPswd());

            ResultSet rs=ps.executeQuery();
            flag=rs.next();
            DBconnect.closeConn(conn,ps,rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean addToDB(User u){
        Connection conn=DBconnect.getConn();
        String sql="insert into userinfo(username,pswd) values(?,?)";
        int judge=0;

        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,u.getName());
            ps.setString(2,u.getPswd());

            judge=ps.executeUpdate();
            DBconnect.closeConn(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(judge!=0){
            return true;
        }else{
            return false;
        }
    }


}
