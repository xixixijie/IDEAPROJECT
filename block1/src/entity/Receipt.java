package entity;

/**
 * Created by xixi on 2018/6/15.
 */
public class Receipt {
    private int rid;
    private String note;
    private int evaluate;
    private double money;
    private int goodID;
    private String goodName;
    private int amount;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(int evaluate) {
        this.evaluate = evaluate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
