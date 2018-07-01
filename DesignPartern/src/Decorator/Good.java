package Decorator;

/**
 * Created by xixi on 2017/10/9.
 */
public abstract class Good {
    String name;
    int money;
    String unit;
    int size;
    public void print(){
        System.out.println(name+" "+size+" "+unit+" "+money+"元");
    }
}
