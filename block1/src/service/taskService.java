package service;

import DBUtil.DBUtil;
import dao.taskDAO;
import dao.taskDAOImp;
import entity.Administrator;
import entity.MissionList;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class taskService {
    private taskService(){

    }

    private static taskService service=new taskService();

    public static taskService getService() {
        return service;
    }

    public List<MissionList> consultTasks(int TID, Date date, int type, int state, String courierName, int pageSize, int pageNum) {
        Connection conn= DBUtil.getConn();
        taskDAO dao=new taskDAOImp(conn);

        return dao.consultTasks(TID,date,type,state,courierName,pageSize,pageNum);
    }

    public List<MissionList> consultTasks(Date beginDate, Date endDate, String goodName) {
        Connection conn= DBUtil.getConn();
        taskDAO dao=new taskDAOImp(conn);

        return dao.consultTasks(beginDate,endDate,goodName);
    }

    public MissionList consultDetail(int TID) {
        Connection conn= DBUtil.getConn();
        taskDAO dao=new taskDAOImp(conn);

        return dao.consultDetail(TID);
    }

    public void disCourier(int tid, int cid, Administrator administrator) {
        Connection conn= DBUtil.getConn();
        DBUtil.beginTransaction(conn);

        taskDAO dao=new taskDAOImp(conn);
        dao.disCourier(tid,cid,administrator);
        DBUtil.commit(conn);
        //System.out.println("分配配送员完成");

    }

    public int selectCount(int tid, Date date, int type, int state, String courierName, int pageSize) {
        Connection conn= DBUtil.getConn();
        DBUtil.beginTransaction(conn);

        taskDAO dao=new taskDAOImp(conn);
        return dao.selectCount(tid,date,type,state,courierName,pageSize);
    }
}
