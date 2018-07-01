package tool;

/**
 * Created by xixi on 2017/8/29.
 */
public class VNode implements Comparable<VNode>{
     String name1;
     String name2;
     int weight;

     public VNode(){}

    public VNode(String name1,String name2,int weight){
        this.name1=name1;
        this.name2=name2;
        this.weight=weight;
    }

    @Override
    public int compareTo(VNode o) {
        return o.weight>weight?-1:1;
    }
}
