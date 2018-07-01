package service;

import DBUtil.DBUtil;
import dao.invoiceDAO;
import dao.invoiceDAOImp;
import entity.Invoice;
import entity.Task;

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

    public List<Invoice> consultInvoices(int tid, int iid) {
        List<Invoice> list=new ArrayList<>();
        Connection conn= DBUtil.getConn();
        invoiceDAO dao=new invoiceDAOImp(conn);
        return dao.consultInvoices(tid,iid);
    }

    public Invoice consultDetail(int tid) {
        List<Invoice> list=new ArrayList<>();
        Connection conn=DBUtil.getConn();
        invoiceDAO dao=new invoiceDAOImp(conn);
        return dao.consultDetail(tid);
    }
}
