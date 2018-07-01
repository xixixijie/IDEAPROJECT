package Complex;

import Complex.wager.Asset;
import Complex.wager.Cash;
import Complex.wager.Jetton;
import Complex.wager.Wager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by xixi on 2017/10/16.
 */
public class User {

    boolean isVIP;

    Map<String, Wager> wagerList;

    public User() {
        isVIP=false;
        wagerList = new HashMap<>();
        wagerList.put("Cash",new Cash());
        wagerList.put("Jetton",new Jetton());
        wagerList.put("Asset",new Asset());
    }

    public boolean isVIP(){
        return isVIP;
    }

    public void pay(double amount) {
        Cash wager = (Cash) wagerList.get("Cash");
        wager.setAmount(wager.getAmount() - amount);

    }


    public void addWager(String type,double amount){
        Wager wager=wagerList.get(type);
        wager.setAmount(wager.getAmount()+amount);
    }

    public double Sum() {
        double sum = 0;

        for (Wager wager : wagerList.values()) {
            sum += wager.getAmount();
        }
        return sum;
    }

    public void show() {
        System.out.println("您有Cash："+wagerList.get("Cash").getAmount());
        System.out.println("您有Jetton："+wagerList.get("Jetton").getAmount());
        System.out.println("您有Asset："+wagerList.get("Asset").getAmount());
    }
}
