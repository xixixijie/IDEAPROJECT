package tool;

/**
 * Created by xixi on 2017/8/29.
 */
public class ArcNode implements Comparable<ArcNode>{
     String name;
    private int MAXNUM = 32767;
     int popularity;//受欢迎程度
     String introduction;//介绍
     boolean isRest;//有没有休息区
     boolean isWC;//有没有厕所
     boolean isVisit;//是否遍历过
     String from;
     int weight;

     public ArcNode(){}

     public ArcNode(String name,int popularity,String introduction,boolean isRest,boolean isWC){
         this.name=name;
         this.popularity=popularity;
         this.introduction=introduction;
         this.isRest=isRest;
         this.isWC=isWC;
         isVisit=false;
         weight=MAXNUM;
     }




    @Override
    public int compareTo(ArcNode o) {
        return o.weight>weight?-1:1;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
