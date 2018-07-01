package dao;

import entity.Invoice;

import java.sql.Connection;
import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class invoiceDAOImp implements invoiceDAO {
    private Connection conn;
    public invoiceDAOImp(Connection conn) {
        this.conn=conn;
    }

    @Override
    public List<Invoice> consultInvoices(int tid, int iid) {
        return null;
    }

    @Override
    public Invoice consultDetail(int tid) {
        return null;
    }
}
