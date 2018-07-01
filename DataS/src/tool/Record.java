package tool;

import java.util.Date;

/**
 * Created by xixi on 2017/9/1.
 */
public class Record {
    String carID;
    Date inTime;
    Date outTime;
    double money;

    public Record(){}

    public Record(String carID, Date date) {
        this.carID=carID;
        this.inTime=date;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
