package DAO;

import DBConnect.DBconnect;
import bean.User;

import java.sql.*;

/**
 * Created by xixi on 31/05/2017.
 */
public class userDao {
    public static boolean add(User u){
        Connection conn= DBconnect.getConn();
        String sql="insert into user(id,pwd,money,bkid) value(?,?,?,?)";
        int judge=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setString(1,u.getId());
            ps.setString(2,u.getPwd());
            ps.setDouble(3,u.getMoney());
            ps.setString(4,u.getBkId());

            judge=ps.executeUpdate();
            DBconnect.closeConn(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(judge!=0){
            return true;
        }else {
            return false;
        }
    }

    public static User check(User u){
        System.out.println(u.getId());
        Connection conn=DBconnect.getConn();
        String sql="select * from user where id=?";
        User user=new User();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,u.getId());

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                user.setId(rs.getString(1));
                user.setPwd(rs.getString(2));
                user.setMoney(rs.getDouble(3));
                user.setBkId(rs.getString(4));
                DBconnect.closeConn(conn,ps,rs);
                return user;

            }
            DBconnect.closeConn(conn,ps,rs);

        }catch (Exception e){

        }
        return null;
    }

    public static boolean addMoney(User u,Double money){
        Connection conn=DBconnect.getConn();
        String sql1="delete from user where id="+u.getId();
        try {
            PreparedStatement ps=conn.prepareStatement(sql1);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        u.setMoney(u.getMoney()+money);
        return add(u);

    }

}
