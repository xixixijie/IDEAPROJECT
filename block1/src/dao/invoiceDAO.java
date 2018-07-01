package dao;

import entity.Invoice;

import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public interface invoiceDAO {
    List<Invoice> consultInvoices(int tid1, int i, int tid, int iid);

    Invoice consultDetail(int tid);

    int selectCount(int tid, int iid, int pageSize);
}
