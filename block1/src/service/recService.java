package service;

import DBUtil.DBUtil;
import dao.recDAO;
import dao.recDAOImp;
import entity.Administrator;
import entity.Receipt;

import java.sql.Connection;

/**
 * Created by xixi on 2018/6/15.
 */
public class recService {
    private recService(){

    }
    private static recService service=new recService();

    public static recService getService(){
        return service;
    }

    public Receipt getReceipt(int rid) {
        Connection connection=DBUtil.getConn();
        recDAO dao=new recDAOImp(connection);

        return dao.getReceipt(rid);
    }



    public void generateRec(int rid, Administrator administrator) {
        Connection connection=DBUtil.getConn();
        DBUtil.beginTransaction(connection);
        recDAO dao=new recDAOImp(connection);
        dao.generateRec(rid,administrator);
        DBUtil.commit(connection);
    }
}
