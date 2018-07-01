package bean;

import java.util.List;

/**
 * Created by xixi on 31/05/2017.
 */
public class User {
    private String id;
    private String pwd;
    private List<Book> bookcase;
    private double money;
    private String bkId;


    public String getBkId() {
        return bkId;
    }

    public void setBkId(String bkId) {
        this.bkId = bkId;
    }

    public List<Book> getBookcase() {
        return bookcase;
    }

    public void setBookcase(List<Book> bookcase) {
        this.bookcase = bookcase;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
