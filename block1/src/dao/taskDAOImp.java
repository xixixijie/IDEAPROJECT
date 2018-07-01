package dao;

import entity.Administrator;
import entity.MissionList;
import entity.OrderInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class taskDAOImp implements taskDAO{

    private Connection conn;

    public taskDAOImp(Connection conn) {
        this.conn=conn;
    }

    @Override
    public List<MissionList> consultTasks(int TID, Date date, int type, int state, String courierName,int pageSize,int pageNum) {
        List<MissionList> list=new ArrayList<>();
        StringBuffer sbf =new StringBuffer();
        //固定本分站id没写
        //根据日期查询也没写
        sbf.append("select * from MISSIONLIST where 1=1 ");
        if(TID!=0 ){
            sbf.append(" and mission_id=? ");
        }
        if(type!=-1){
            sbf.append(" and mission_type=?");
        }
        if(state!=-1){
            sbf.append(" and mission_state=?");
        }

        try {
            String sql="select b.* from (select a.*,rownum rw from("+sbf.toString()+") a where rownum<= "+pageNum*pageSize+" ) b where rw> "+(pageNum-1)*pageSize;
            PreparedStatement ps=conn.prepareStatement(sql);
            //System.out.println("查询任务单sql："+sql);
            int index=1;
            if(TID!=0){
                ps.setInt(index++,TID);
            }
            if(type!=-1){
                ps.setInt(index++,type);
            }
            if(state!=-1){
                ps.setInt(index++,state);
            }
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                MissionList ml=new MissionList();
                ml.setMissionID(rs.getInt("mission_id"));
                ml.setMissionType(rs.getInt("mission_type"));
                ml.setMissionState(rs.getInt("mission_state"));
                ml.setCourier(rs.getInt("courier_code"));
                list.add(ml);
            }

            //DBUtil.closeConn(conn,ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //System.out.println(list.size());
        return list;
    }

    @Override
    public MissionList consultDetail(int TID) {
        //System.out.println("查询详细"+TID);
        MissionList missionList=new MissionList();
        String sql="select * from missionList where mission_id=?";

        PreparedStatement ps= null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,TID);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){
                //保存order信息
                OrderInfo orderInfo=new OrderInfo();
                orderInfo.setOrderID(rs.getInt("order_id"));

                missionList.setMissionID(rs.getInt("mission_id"));
                missionList.setOrderInfo(orderInfo);
                missionList.setSubstationCode(rs.getInt("Substation_Code"));
                missionList.getCourier().setCID(rs.getInt("courier_code"));
                missionList.setMissionType(rs.getInt("mission_type"));
                missionList.setMissionState(rs.getInt("mission_state"));
                missionList.setNote(rs.getString("note"));
                missionList.setIsAccount(rs.getInt("isaccount"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return missionList;
    }

    @Override
    public void disCourier(int tid, int cid, Administrator administrator) {
        String sql="update missionlist set mission_state=?,courier_code=?,operation_id=?,operation_date=? where mission_id=?";
        //System.out.println("进入分配配送员dao");
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,4);
            ps.setInt(2,cid);
            ps.setInt(3,administrator.getAID());
            ps.setDate(4,new java.sql.Date(administrator.getOperateDate().getTime()));
            ps.setInt(5,tid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<MissionList> consultTasks(Date beginDate, Date endDate, String goodName) {
        return null;
    }

    @Override
    public int selectCount(int tid, Date date, int type, int state, String courierName, int pageSize) {
        int count=0;
        List<MissionList> list=new ArrayList<>();
        StringBuffer sbf =new StringBuffer();
        //固定本分站id没写
        sbf.append("select count(*) cc from MISSIONLIST where 1=1 ");
        if(tid!=0 ){
            sbf.append(" and mission_id=? ");
        }
        if(type!=-1){
            sbf.append(" and mission_type=?");
        }
        if(state!=-1){
            sbf.append(" and mission_state=?");
        }

        System.out.println(sbf.toString());
        try {
            PreparedStatement ps=conn.prepareStatement(sbf.toString());

            int index=1;
            if(tid!=0){
                ps.setInt(index++,tid);
            }
            if(type!=-1){
                ps.setInt(index++,type);
            }
            if(state!=-1){
                ps.setInt(index++,state);
            }
            ResultSet rs=ps.executeQuery();

            if(rs.next())
                count=rs.getInt("cc");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println("数据总大小"+count);

        return count%pageSize==0?count/pageSize:count/pageSize+1;
    }
}
