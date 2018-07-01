package entity;

import service.courierService;

import java.util.Date;

/**
 * Created by xixi on 2018/6/15.
 */
public class MissionList {
    private int missionID;

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    private OrderInfo orderInfo=new OrderInfo();
    private int substationCode;
    private String note;
    private int isAccount;
    private Date date;
    private int missionType;
    private String type;
    private int missionState;
    private String state;
    private Courier courier=new Courier();

    public int getSubstationCode() {
        return substationCode;
    }

    public void setSubstationCode(int substationCode) {
        this.substationCode = substationCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIsAccount() {
        return isAccount;
    }

    public void setIsAccount(int isAccount) {
        this.isAccount = isAccount;
    }



    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo){
        this.orderInfo=orderInfo;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(int courier) {
        this.courier.setCID(courier);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getMissionID() {
        return missionID;
    }
    //转换任务类型，配送员姓名等
    public void switchInt(){
        switch (missionType){
            case 0:
                type="送货";
                break;
            case 1:
                type="退货";
        }
        switch (missionState){
            case 2:
                state="缺货";
                break;
            case 3:
                state="可分配";
                break;
            case 4:
                state="已分配";
                break;
            case 5:
                state="已领货";
                break;
            case 6:
                state="已完成";
                break;
        }
        //获得配送员名字

        //System.out.println(this.getCourier().getCID());
        //System.out.println(courierService.getService().getCourerName(this.getCourier().getCID()));
        this.getCourier().setName(courierService.getService().getCourerName(this.getCourier().getCID()));

    }

    public void setMissionID(int missionID) {
        this.missionID = missionID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMissionType() {
        return missionType;
    }

    public void setMissionType(int missionType) {
        this.missionType = missionType;
    }

    public int getMissionState() {
        return missionState;
    }

    public void setMissionState(int missionState) {
        this.missionState = missionState;
    }
}
