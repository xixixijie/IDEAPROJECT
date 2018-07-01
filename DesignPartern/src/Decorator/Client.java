package Decorator;

/**
 * Created by xixi on 2017/10/9.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("    东北大学超市    ");
        System.out.println("------------------");
        Good cola=new Cola();
        BreadDecorator bd=new BreadDecorator(cola);
        bd.print();
        System.out.println();
        System.out.println();
        System.out.println("合计 "+"      "+bd.sum()+"元");
        System.out.println("------------------");
        System.out.println("balabala...");

    }
}
