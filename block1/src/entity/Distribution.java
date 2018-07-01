package entity;

import java.util.Date;

/**
 * Created by xixi on 2018/6/15.
 */
public class Distribution {
    private int did;
    private MissionList missionList;
    private Receipt receipt;
    private Date sendDate;
    private Date OKDate;
    private String clientName;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public MissionList getMissionList() {
        return missionList;
    }

    public void setMissionList(MissionList missionList) {
        this.missionList = missionList;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getOKDate() {
        return OKDate;
    }

    public void setOKDate(Date OKDate) {
        this.OKDate = OKDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
