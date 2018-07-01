package service;

import entity.Distribution;

import java.util.List;

/**
 * Created by xixi on 2018/6/15.
 */
public class disService {
    private disService(){

    }

    private static disService service=new disService();

    public static disService getService(){
        return service;
    }

    public List<Distribution> printDis(int[] tid) {
        List<Distribution> list=null;
        //先查数据库有没有，有则返回，没有则生成

        return null;
    }

    public Distribution printDis(int tid){

        return null;
    }
}
