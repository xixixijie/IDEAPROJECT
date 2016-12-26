package dao;

import DBconnect.DBconnect;
import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jay chen on 2016/9/14.
 */
public class userAction {
    //登陆
    public static boolean login(User u){
        Connection conn=DBconnect.getConn();
        String sql="select * from user where id=? and pwd=?";
        boolean flag=false;
        try{
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,u.getId());
            ps.setString(2,u.getPwd());

            ResultSet rs=ps.executeQuery();
            flag=rs.next();
            u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setMajor(rs.getString("major"));
            u.setGender(rs.getString("gender"));
            u.setGrade(rs.getString("grade"));
            u.setAge(rs.getString("age"));
            u.setUniversity(rs.getString("university"));
            u.setCollege(rs.getString("college"));

            DBconnect.closeConn(conn,ps,rs);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return flag;
    }
    //注册
    public static boolean register(User u){
        Connection conn=DBconnect.getConn();
        String sql="insert into user(id,name,pwd,university,college,major,grade,gender,age,email) values(?,?,?,?,?,?,?,?,?,?)";
        int judge=0;
        try{
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,u.getId());
            ps.setString(2,u.getName());
            ps.setString(3,u.getPwd());
            ps.setString(4,u.getUniversity());
            ps.setString(5,u.getCollege());
            ps.setString(6,u.getMajor());
            ps.setString(7,u.getGrade());
            ps.setString(8,u.getGender());
            ps.setString(9,u.getAge());
            ps.setString(10,u.getEmail());

            judge=ps.executeUpdate();
            DBconnect.closeConn(conn,ps);
        }catch (SQLException e){
            e.printStackTrace();
        }

        if(judge!=0){
            return true;
        }else {
            return false;
        }
    }
}
