package DAO;

import DBconnect.DBconnect;
import bean.DividePage;
import bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay chen on 2016/9/2.
 */
public class ProDao {
    //加入数据库
    public static boolean addToDB(Product p){
        Connection conn= DBconnect.getConn();
        String sql="insert into product(proname,proprice,proaddress,proimage) values(?,?,?,?,?)";
        int judge=0;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);


            ps.setString(1,p.getName());
            ps.setString(2,p.getPrice());
            ps.setString(3,p.getAddress());
            ps.setString(4,p.getImage());

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
    //
    public static List<Product> find(int page) {
        List<Product> list = new ArrayList<>();
        Connection conn = DBconnect.getConn();
        String sql = "select * from product order by proid asc limit ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt((int) 1, (page - 1) * DividePage.getPageSize());
            ps.setInt((int) 2, DividePage.getPageSize());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("proid"));
                p.setName(rs.getString("proname"));
                p.setAddress(rs.getString("proaddress"));
                p.setPrice(rs.getString("proprice"));
                list.add(p);
            }
            DBconnect.closeConn(conn, ps, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int findCount(){
        int count=0;
        Connection conn= DBconnect.getConn();
        String sql="select count(*) from product";

        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                count=rs.getInt(1);
            }
            DBconnect.closeConn(conn,stmt,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
