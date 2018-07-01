package dao;

import entity.Invoice;
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
public class invoiceDAOImp implements invoiceDAO {
    private Connection conn;
    public invoiceDAOImp(Connection conn) {
        this.conn=conn;
    }

    @Override
    public List<Invoice> consultInvoices(int tid, int iid, int pageSize, int pageNum) {

        List<Invoice> invoiceList=new ArrayList<>();
        StringBuffer sbf=new StringBuffer();
        sbf.append("select a.mission_ID mid,b.* from missionlist a,invoice b where a.order_id=b.order_id");

        if(tid!=0){
            sbf.append(" and a.mission_id=? ");
        }
        if(iid!=0){
            sbf.append(" and b.invoice_id=? ");
        }

        System.out.println(sbf.toString());
        String sql="select b.* from (select a.*,rownum rw from("+sbf.toString()+") a where rownum <= "+pageNum*pageSize+" ) b where rw>"+(pageNum-1)*pageSize;
        try {
            PreparedStatement ps=conn.prepareStatement(sql);

            int index=1;
            if(tid!=0)
                ps.setInt(index++,tid);
            if(iid!=0)
                ps.setInt(index++,iid);

            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Invoice invoice=new Invoice();
                invoice.setInvoiceID(rs.getInt("invoice_id"));
                invoice.setMissionID(rs.getInt("mid"));
                invoice.setState(rs.getInt("status"));


                invoiceList.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoiceList;
    }

    @Override
    public Invoice consultDetail(int iid) {
        Invoice invoice=new Invoice();

        String sql="select * from invoice a,orderInfo b where a.order_id=b.order_id and a.invoice_id=?";

        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,iid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                OrderInfo orderInfo=new OrderInfo();
                orderInfo.setOrderID(rs.getInt("order_id"));


                invoice.setOrderInfo(orderInfo);

                invoice.setInvoiceID(rs.getInt("invoice_id"));
                invoice.setAmount(rs.getDouble("amount"));
                if(rs.getDate("register_date")!=null)
                    invoice.setRegDate(new Date(rs.getDate("register_date").getTime()));
                if(rs.getDate("receipt_date")!=null)
                    invoice.setRecDate(new Date(rs.getDate("receipt_date").getTime()));

                invoice.setRecID(rs.getInt("receipt_ID"));
                if(rs.getDate("lost_date")!=null)
                    invoice.setLostDate(new Date(rs.getDate("lost_date").getTime()));
                invoice.setLostID(rs.getInt("lost_id"));
                invoice.setSubstationID(rs.getInt("substation_code"));
                invoice.setState(rs.getInt("status"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoice;
    }

    @Override
    public int selectCount(int tid, int iid, int pageSize) {
        int count=0;
        StringBuffer sbf=new StringBuffer();
        sbf.append("select count(*) cc from missionlist a,invoice b where a.order_id=b.order_id");

        if(tid!=0){
            sbf.append(" and a.mission_id=? ");
        }
        if(iid!=0){
            sbf.append(" and b.invoice_id=? ");
        }

        System.out.println(sbf.toString());

        try {
            PreparedStatement ps=conn.prepareStatement(sbf.toString());

            int index=1;
            if(tid!=0)
                ps.setInt(index++,tid);
            if(iid!=0)
                ps.setInt(index++,iid);

            ResultSet rs=ps.executeQuery();

           if(rs.next())
               count=rs.getInt("cc");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
