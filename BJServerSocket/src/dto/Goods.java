package dto;

/**
 * Created by jay chen on 2016/5/10.
 */
public class Goods {
    String g_id;
    String g_name;
    double g_price;
    int g_count;

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public int getG_count() {
        return g_count;
    }

    public void setG_count(int g_count) {
        this.g_count = g_count;
    }
}
