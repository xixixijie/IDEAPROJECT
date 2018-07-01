package service;

/**
 * Created by xixi on 2018/6/15.
 */
public class recService {
    private recService(){

    }
    private static recService service=new recService();

    public static recService getService(){
        return service;
    }
}
