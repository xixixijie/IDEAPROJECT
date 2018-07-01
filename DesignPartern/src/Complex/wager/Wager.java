package Complex.wager;

/**
 * Created by xixi on 2017/10/13.
 */
public class Wager {
    Wager wager;
    double amount;
    String name;

    public double sum(){
        return amount+wager.amount;
    }

    public Wager getWager() {
        return wager;
    }

    public void setWager(Wager wager) {
        this.wager = wager;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
