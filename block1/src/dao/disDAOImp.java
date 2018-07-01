package dao;

import entity.Administrator;
import entity.Distribution;
import entity.MissionList;
import entity.Receipt;
import service.recService;
import service.taskService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by xixi on 2018/6/15.
 */
public class disDAOImp implements disDAO {
    private Connection conn;

    public disDAOImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Distribution getDis(int tid) {
        Distribution distribution=null;
        String sql="select * from Distribution where tid=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1,tid);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                distribution=new Distribution();
                distribution.setDid(rs.getInt("did"));
                MissionList missionList= taskService.getService().consultDetail(rs.getInt("tid"));
                distribution.setMissionList(missionList);

                Receipt receipt= recService.getService().getReceipt(rs.getInt("rid"));
                distribution.setReceipt(receipt);
                if(rs.getDate("senDate")!=null)
                    distribution.setSendDate(new Date(rs.getDate("sendate").getTime()));
                if(rs.getDate("okdate")!=null)
                    distribution.setOKDate(new Date(rs.getDate("okdate").getTime()));
                distribution.setClientName(rs.getString("clientname"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return distribution;
    }

    @Override
    public void generateDis(Distribution distribution, Administrator administrator) {
        String sql="insert into distribution values(seq_dis.nextval,seq_dis.currval,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,distribution.getMissionList().getMissionID());
            ps.setInt(2,distribution.getReceipt().getRid());
            ps.setDate(3,new java.sql.Date(new Date().getTime()));
            ps.setDate(4,null);
            ps.setString(5,null);
            ps.setInt(6,administrator.getAID());
            ps.setDate(7,new java.sql.Date(administrator.getOperateDate().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
