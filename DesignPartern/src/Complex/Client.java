package Complex;

import Complex.Adapter.WagerAdapter;
import Complex.Facade.GamblingHouse;
import Complex.Factory.Creator;
import Complex.Strategy.CommonStrategy;
import Complex.Strategy.Strategy;
import Complex.Strategy.VIPStrategy;
import Complex.Thing.Watch;
import Complex.wager.Cash;
import Complex.wager.Jetton;
import Complex.wager.Wager;

import java.awt.event.WindowAdapter;

/**
 * Created by xixi on 2017/10/13.
 */
public class Client {
    //static Strategy strategy=new VIPStrategy();
    public static void main(String[] args) {
        GamblingHouse gamblingHouse=new GamblingHouse();
        gamblingHouse.Start();

    }



}
