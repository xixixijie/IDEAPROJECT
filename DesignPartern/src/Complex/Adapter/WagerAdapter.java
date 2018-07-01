package Complex.Adapter;

import Complex.Thing.Thing;
import Complex.wager.Wager;

/**
 * Created by xixi on 2017/10/15.
 */
public class WagerAdapter extends Wager{

    public WagerAdapter(Thing thing){
        this.setAmount(thing.getMoney());
        this.setName(thing.getName());
    }
}
