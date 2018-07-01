package Singleton;

/**
 * Created by xixi on 2017/10/9.
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("测试Eager");
        System.out.println("初始值为：");
        System.out.println(EagerSing.getSingleton());
        EagerSing.setSingleton(2);
        System.out.println("修改后：");
        System.out.println(EagerSing.getSingleton()+"\n");

        System.out.println("测试Lazy");
        System.out.println(LazySing.getSingleton());
        System.out.println("第二次调用getSIngleton()");
        System.out.println(LazySing.getSingleton());

    }
}
