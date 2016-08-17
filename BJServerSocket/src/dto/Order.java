package dto;

/**
 * Created by jay chen on 2016/5/10.
 */
public class Order {
    String o_id;
    String o_u_name;
    String o_u_id;
    String o_amount;

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getO_u_name() {
        return o_u_name;
    }

    public void setO_u_name(String o_u_name) {
        this.o_u_name = o_u_name;
    }

    public String getO_u_id() {
        return o_u_id;
    }

    public void setO_u_id(String o_u_id) {
        this.o_u_id = o_u_id;
    }

    public String getO_amount() {
        return o_amount;
    }

    public void setO_amount(String o_amount) {
        this.o_amount = o_amount;
    }
}
