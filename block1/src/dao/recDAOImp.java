package dao;

import entity.Administrator;
import entity.Receipt;

import java.sql.*;

/**
 * Created by xixi on 2018/6/15.
 */
public class recDAOImp implements recDAO {
    private Connection conn;

    public recDAOImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Receipt getReceipt(int rid) {
        Receipt receipt=null;
        String sql="select * from receipt where rid=?";

        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1,rid);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                receipt=new Receipt();
                receipt.setRid(rs.getInt("rid"));
                receipt.setNote(rs.getString("note"));
                receipt.setEvaluate(rs.getInt("evaluate"));
                receipt.setMoney(rs.getDouble("money"));
                receipt.setGoodID(rs.getInt("gid"));
                receipt.setGoodName(rs.getString("GName"));
                receipt.setAmount(rs.getInt("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return receipt;

    }

    @Override
    public void generateRec(int rid, Administrator administrator) {
        String sql="insert into receipt values(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            ps.setInt(1,rid);
            ps.setInt(2,rid);
            ps.setString(3,null);
            ps.setInt(4,0);
            ps.setInt(5,0);
            ps.setInt(6,7);
            ps.setString(7,null);
            ps.setInt(8,0);
            ps.setInt(9,administrator.getAID());
            ps.setDate(10,new Date(administrator.getOperateDate().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
