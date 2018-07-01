package DBconnect;

import tool.Admin;

import java.sql.*;

/**
 * Created by xixi on 2017/8/30.
 */
//Data Access Objects 数据访问层
public class AdminDao {
    public static boolean getAdmin(String id,String pswd){
        Connection conn= DBconnect.getConn();
        String sql="select * from Admin WHERE id=?";
        String str="";
        try {
            PreparedStatement sm=conn.prepareStatement(sql);
            sm.setString(1,id);
            ResultSet rs=sm.executeQuery();
            if(rs==null){
                return false;
            }
            if(rs.next()){
               str=rs.getString(1);
            }else {
                return false;
            }
            DBconnect.closeConn(conn,sm,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return str.equals(pswd);
    }

}
