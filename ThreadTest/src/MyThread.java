/**
 * Created by jay chen on 2016/6/13.
 */
public class MyThread implements Runnable{

    int num;
    MyThread(){
        num=10;
    }

    public static void main(String[] args) {
        MyThread mt=new MyThread();

        Thread t1=new Thread(mtrf4vgtttb);
        t1.start();
        Thread t2=new Thread(mt);
        t2.start();
    }


    @Override
    public void run() {

        System.out.println();
    }
}

