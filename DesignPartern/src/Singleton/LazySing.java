package Singleton;

/**
 * Created by xixi on 2017/10/9.
 */
public class LazySing {
    private static Integer singleton=null;

    public LazySing(){}

    public static synchronized Integer getSingleton(){
        if(singleton==null){
            System.out.println("singleton初始化了");
            singleton=new Integer(0);
        }
        return singleton;
    }

    public static void setSingleton(int num){
        singleton=num;
    }
}
