import static java.lang.Thread.*;

/**
 * Created by jay chen on 2016/6/13.
 */
public class TwoThread implements Runnable {
    TwoThread() throws InterruptedException {
        Thread t1 = currentThread();
        t1.setName("The First");
        System.out.println("The running thread :"+t1);

        Thread t2=new Thread(this,"The Second");
        t2.start();

        System.out.println("the first will sleep");
        Thread.sleep(3000);

        System.out.println("the first exit");

    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("Sleep time for thread 2: "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {
        new TwoThread();
    }
}
