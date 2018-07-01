import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xixi on 2017/12/6.
 */
public class GossipNode implements Runnable {
    static int acount = 0;
    private String name;
    private double data;
    private double interest;
    private double probability;
    List<GossipNode> all;


    GossipNode(double data, String name) {
        this.data = data;
        this.name = name;
        interest = 10000;
    }

    GossipNode(double data, String name, double interest) {
        this.data = data;
        this.name = name;
        this.interest = interest;
    }

    public void setAll(List<GossipNode> all) {
        this.all = all;
        probability = 1.0 / (all.size());
        //System.out.println(probability);
    }

    @Override
    public void run() {

        while (quit()) {
            //System.out.print(this.name + ":"+this.getData());

            //GossipNode n2 = all.get(new Random().nextInt(all.size()));
//            while (true) {
//                if (new Random().nextDouble() < n2.probability) {
//                    break;
//                }
//                n2 = all.get(new Random().nextInt(all.size()));
//        }
            //System.out.println(this.data + ":" + n2.getData());
            for(GossipNode n2:all){
                if (new Random().nextDouble() < n2.probability) {
                      exchange(this, n2);
                }

            }

            //System.out.println("交换之后" + this.data + ":" + n2.getData());
        }
        for (int i = 0; i < 50000; )
            i++;
        System.out.println("节点" + this.name + ":" + this.data);
        //System.out.println("次数"+acount);
    }

    public boolean quit() {
        boolean flag = false;
        double avg = this.getData();
        for (GossipNode gn : all) {
            if (gn.getData() != avg) {
                flag = true;
            }
        }

        return flag;
    }

    private synchronized void exchange(GossipNode n1, GossipNode n2) {

//        if (n1.getInterest() != n2.getInterest()) {
        //System.out.println(n1.getData() + ":" + n2.getData());
        float avg = (float) ((n1.getData() + n2.getData()) / 2);
        n1.setData(avg);
        n2.setData(avg);
        //概率衰减
        n1.probability=n1.probability*(1-1/all.size());
        n2.probability=n2.probability*(1-1/all.size());
        // n1.setInterest((n1.getInterest() > n2.getInterest() ? (n1.getInterest() - 1) : (n2.getInterest() - 1)));
        //  n2.setInterest((n1.getInterest() > n2.getInterest() ? (n1.getInterest() - 1) : (n2.getInterest() - 1)));
        acount++;
        //}


    }

    public void setData(double data) {
        this.data = data;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getData() {
        return data;
    }

    public double getInterest() {
        return interest;
    }

    public static void main(String[] args) throws InterruptedException {
        int Size=1000;
        List<GossipNode> list=new ArrayList<>();
        list.add(new GossipNode(0,"0",9999));
        for(int i=1;i<Size;i++){
            list.add(new GossipNode(new Random().nextInt(Size),""+i));
        }

        List<Thread> threads=new ArrayList<>();


        for(GossipNode gn:list){
            gn.setAll(list);
//            System.out.println(gn.getData());
            Thread  t=new Thread(gn);
            threads.add(t);
            t.start();
        }

        for(Thread t:threads){
            t.join();
        }


        System.out.println("运行次数"+new GossipNode(0,"h").acount);
        System.out.println("误差：因为我退出条件是直接相等才退出，所以精度就是double类型的精度，16~17位有效数字");
    }

}
