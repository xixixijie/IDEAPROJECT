package entity;

import java.util.Date;

/**
 * Created by xixi on 2018/6/15.
 */
public class Administrator {
    private int AID=4;
    private int stationID=1;

    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public Date getOperateDate(){
        return new Date();
    }
}
