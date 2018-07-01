package Complex.Thing;

/**
 * Created by xixi on 2017/10/15.
 */
public class Thing {
    String name;
    double money;

    public Thing(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
