package DBconnect;

import tool.Record;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by xixi on 2017/9/2.
 */
public class RecordDao {
    public static List<Record> getRecords(){
        Connection conn= DBconnect.getConn();
        List<Record> list=new ArrayList<>();
        String sql="select * from Record";
        try  {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Record r=new Record();
                r.setMoney(rs.getDouble(4));
                r.setInTime(new Date(rs.getTimestamp(2).getTime()));
                r.setOutTime(new Date(rs.getTimestamp(3).getTime()));
                r.setCarID(rs.getString(1));

                list.add(r);
            }

            DBconnect.closeConn(conn,ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void addRecord(Record r){
        Connection conn= DBconnect.getConn();
        String sql="insert into Record values(?,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,r.getCarID());
            //System.out.println(r.getOutTime().getTime());
            ps.setTimestamp(2, new Timestamp(r.getInTime().getTime()));
            ps.setTimestamp(3,new Timestamp(r.getOutTime().getTime()));
            ps.setDouble(4,r.getMoney());
            ps.setString(5, String.valueOf(r.hashCode()));
            if(ps.executeUpdate()!=0){
                System.out.println("插入成功");
            }
            DBconnect.closeConn(conn,ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
