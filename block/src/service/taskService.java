package service;

import DBUtil.DBUtil;
import dao.taskDAO;
import dao.taskDAOImp;
import entity.Task;

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

    public List<Task> consultTasks(int TID, Date date, int type, int state, String courierName) {
        Connection conn= DBUtil.getConn();
        taskDAO dao=new taskDAOImp(conn);

        return dao.consultTasks(TID,date,type,state,courierName);
    }

    public Task consultDetail(int TID) {
        Connection conn= DBUtil.getConn();
        taskDAO dao=new taskDAOImp(conn);

        return dao.consultDetail(TID);
    }

    public void disCourier(int tid, int cid) {
        Connection conn= DBUtil.getConn();
        DBUtil.beginTransaction(conn);

        taskDAO dao=new taskDAOImp(conn);
        dao.disCourier(tid,cid);

    }
}
