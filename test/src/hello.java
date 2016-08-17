/**
 * Created by jay chen on 2016/6/25.
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class hello {
    int num;

    public int getNum(){
        return num;
    }
    public hello(int num){
        this.num=num;
    }
    public String toString(){
        return num+"";
    }

    public static void main(String[] args) {
        Comparator<hello> cprt=new Comparator<hello>() {
            @Override
            public int compare(hello o1, hello o2) {
                int a=o1.getNum();
                int b=o2.getNum();
                if(a<b){
                    return 1;
                }else if(a>b){
                    return -1;
                }else{
                    return 0;
                }
            }
        };
        PriorityQueue<hello> pq=new PriorityQueue<hello>(cprt);

        pq.add(new hello(1));
        pq.add(new hello(7));
        pq.add(new hello(3));
        pq.add(new hello(6));
        pq.add(new hello(45));



       for(int i=0;i<5;i++){
           System.out.print(pq.toArray()[i]+" ");
       }

        System.out.println("\n弹出第一个"+pq.poll());

        for(int i=0;i<4;i++){
            System.out.print(pq.toArray()[i]+" ");
        }

    }
}
