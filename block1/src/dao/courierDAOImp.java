package dao;

import DBUtil.DBUtil;
import entity.Courier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/6/20.
 */
public class courierDAOImp implements courierDAO{
    private Connection conn;

    public courierDAOImp(Connection conn) {
        this.conn=conn;
    }
    @Override
    public String getCourierName(int cid) {
        String name="";
        String sql="select * from Courier where cid=?";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1,cid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
                name=rs.getString("name");
            }


            //DBUtil.closeConn(conn,ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;

    }

    @Override
    public List<Courier> getCouriers() {
        List<Courier> couriers=new ArrayList<>();
        String sql="select * from courier";

        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Courier courier=new Courier();
                courier.setCID(rs.getInt("CID"));
                courier.setName(rs.getString("name"));
                couriers.add(courier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couriers;
    }
}
