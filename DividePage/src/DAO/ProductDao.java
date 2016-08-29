package DAO;

import bean.Product;
import connect.DBconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ProductDao {
    public List<Product> find(int page) {
        List<Product> list = new ArrayList<>();
        Connection conn = DBconnect.getConn();
        String sql = "select * from tb_product order by id desc limit ?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt((int) 1, (page - 1) * Product.PAGE_SIZE);
            ps.setInt((int) 2, Product.PAGE_SIZE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setNum(rs.getInt("num"));
                p.setPrice(rs.getDouble("price"));
                p.setUnit(rs.getString("unit"));
                list.add(p);
            }
            DBconnect.closeConn(conn, ps, rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int findCount(){
        int count=0;
        Connection conn= DBconnect.getConn();
        String sql="select count(*) from tb_product";

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

