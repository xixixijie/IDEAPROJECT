package service;

import DBUtil.DBUtil;
import dao.courierDAO;
import dao.courierDAOImp;
import entity.Courier;

import java.sql.Connection;
import java.util.List;

/**
 * Created by xixi on 2018/6/20.
 */
public class courierService {

    private courierService(){

    }

    private static courierService service=new courierService();

    public static courierService getService(){
        return service;
    }

    public String getCourerName(int CID){
        Connection connection=DBUtil.getConn();
        courierDAO dao= new courierDAOImp(connection);
        return dao.getCourierName(CID);
    }

    public List<Courier> getCouriers() {
        Connection connection=DBUtil.getConn();
        courierDAO dao= new courierDAOImp(connection);
        return dao.getCouriers();
    }
}
