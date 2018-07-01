package dao;

import entity.Task;

import java.sql.Connection;
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
    public List<Task> consultTasks(int TID, Date date, int type, int state, String courierName) {
        List<Task> list=new ArrayList<>();
        StringBuffer sbf =new StringBuffer();
        sbf.append("select * from task where 1=1 ");
//        if(taskID!=null && !"".equals(taskID)){
//            sbf.append(" and taskID=? ");
//        }
//        if(date!=null){
//            sbf.append(" and date=? ")
//        }
//        PreparedStatement ps=null;
        return null;
    }

    @Override
    public Task consultDetail(int TID) {

        return null;
    }

    @Override
    public void disCourier(int tid, int cid) {

    }
}
