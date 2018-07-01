package Complex.Factory;

import Complex.wager.Asset;
import Complex.wager.Cash;
import Complex.wager.Jetton;
import Complex.wager.Wager;

/**
 * Created by xixi on 2017/10/13.
 */
public class Creator {
    public Wager creatCreat(String type){
        switch (type){
            case "Asset":
                return new Asset();
            case "Cash":
                return new Cash();
            case "Jetton":
                return new Jetton();
        }

        return new Wager();
    }
}
