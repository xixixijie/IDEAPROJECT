package Decorator;

/**
 * Created by xixi on 2017/10/9.
 */
public class Decorator extends Good {
     Good good;

    @Override
    public void print() {
        good.print();
        System.out.println(name+" "+size+" "+unit+" "+money+"元");
    }

    public int sum(){
        return this.money+good.money;
    }
}
