package Singleton;

/**
 * Created by xixi on 2017/10/9.
 */
public class EagerSing {
    static private Integer singleton=new Integer(0);

    public static Integer getSingleton(){
        return singleton;
    }

    public static void setSingleton(int num){
        singleton=num;
    }
}
