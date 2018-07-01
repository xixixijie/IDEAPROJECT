package service;

import DBUtil.DBUtil;
import dao.invoiceDAO;
import dao.invoiceDAOImp;
import entity.Invoice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class invoiceService {
    private invoiceService(){}
    private static invoiceService service=new invoiceService();

    public static invoiceService getService(){
        return service;
    }

    public List<Invoice> consultInvoices(int tid, int iid, int pageSize, int pageNum) {
        List<Invoice> list=new ArrayList<>();
        Connection conn= DBUtil.getConn();
        invoiceDAO dao=new invoiceDAOImp(conn);
        return dao.consultInvoices(tid,iid,pageSize,pageNum);
    }

    public Invoice consultDetail(int iid) {

        Connection conn= DBUtil.getConn();
        invoiceDAO dao=new invoiceDAOImp(conn);
        return dao.consultDetail(iid);
    }

    public int selectCount(int tid, int iid, int pageSize) {
        Connection conn= DBUtil.getConn();
        invoiceDAO dao=new invoiceDAOImp(conn);
        return dao.selectCount(tid,iid,pageSize);
    }
}
