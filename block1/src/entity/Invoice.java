package entity;

import java.util.Date;

/**
 * Created by xixi on 2018/6/15.
 */
public class Invoice {
    private int missionID;



    private int invoiceID;
    private double amount;
    private Date regDate;
    private Date recDate;
    private int recID;
    private Date lostDate;
    private int lostID;
    private int substationID;
    private int state;
    private String stateStr;
    private OrderInfo orderInfo;

    public int getMissionID() {
        return missionID;
    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public int getRecID() {
        return recID;
    }

    public void setRecID(int recID) {
        this.recID = recID;
    }

    public Date getLostDate() {
        return lostDate;
    }

    public void setLostDate(Date lostDate) {
        this.lostDate = lostDate;
    }

    public int getLostID() {
        return lostID;
    }

    public void setLostID(int lostID) {
        this.lostID = lostID;
    }

    public int getSubstationID() {
        return substationID;
    }

    public void setSubstationID(int substationID) {
        this.substationID = substationID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void switchInt(){
        switch (state){
            case 1:
                stateStr="正常";
                break;
            case 2:
                stateStr="分站已领用";
                break;
            case 3:
                stateStr="客户已领用";
                break;
            case 4:
                stateStr="作废";
                break;

        }
    }
}
