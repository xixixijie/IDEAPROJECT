package Complex.Strategy;

/**
 * Created by xixi on 2017/10/15.
 */
public class VIPStrategy implements Strategy{

    @Override
    public double Algorithm(double money) {
        return money*1.2;
    }
}
