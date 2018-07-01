package Decorator;

/**
 * Created by xixi on 2017/10/9.
 */
public class BreadDecorator extends Decorator {
    public BreadDecorator(Good good){
        this.unit="g";
        this.name="面包";
        this.money=4;
        this.size=230;
        this.good=good;
    }
}
