/**
 * Created by xixi on 22/06/2017.
 */
public class test {
    private static Integer num=0;
    private static Integer size=5;
    public static void main(String[] args) {
        final test t=new test();
        new Thread(){
            @Override
            public void run() {
                try {
                    t.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    t.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public  void product() throws InterruptedException {
        synchronized (this){
            while(true) {
                if (num < size) {
                    num++;
                    System.out.println("生产了一个肥皂,现在有" + num + "个");
                    Thread.sleep(1000);
                    notify();

                }

                if (num == size) {
                    System.out.println("满了，无法生产");
                    wait();
                }
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this){
            while(true){
            if(num>0){
                num--;
                System.out.println("一个肥皂被消耗了，只剩下"+num+"个");
                notify();

            }
                Thread.sleep(1000);
            if(num==0){
                System.out.println("没肥皂了");
                wait();
            }
        }
        }
    }
}
