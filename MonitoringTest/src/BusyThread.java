/**
 * Created by xixi on 06/04/2017.
 */
public class BusyThread {
    public static void creatBusyThread(){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                    ;
            }
        },"testBusyThread");
        thread.start();
    }
}
