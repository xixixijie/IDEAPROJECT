import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xixi on 22/06/2017.
 */
public class test {
    public static void main(String[] args) {
        PCB p[]=new PCB[5];
        p[0]=new PCB("p1",2,0,"R");
        p[1]=new PCB("p2",3,0,"R");
        p[2]=new PCB("p3",1,0,"R");
        p[3]=new PCB("p4",2,0,"R");
        p[4]=new PCB("p5",4,0,"R");
        p[0].setNextp(p[1]);
        p[1].setNextp(p[2]);
        p[2].setNextp(p[3]);
        p[3].setNextp(p[4]);
        p[4].setNextp(p[0]);
        int a=0;
        PCB temp=p[1];
        for(int i=1;;){

            if(allEnd(p))
                break;
            if(temp.getStates().equals("E")){
                temp=temp.getNextp();
                continue;
            }
            temp.setRunTime(temp.getRunTime()+1);
            temp.setStates("W");
            System.out.println("CPUTIME:"+i);
            for(int j=0;j<5;j++){
                System.out.println(p[j].getName()+" 执行，需要时间 "+p[j].getNeedTime()+" ,已执行"+p[j].getRunTime()+" 状态:"+p[j].getStates());
            }
            temp.setStates("R");
            System.out.println();

            if(temp.getNeedTime()==temp.getRunTime()){
                temp.setStates("E");
            }


            temp=temp.getNextp();
            i++;
        }
    }

    public static boolean allEnd(PCB[] pcbs){
        int a=0;
        for(int i=0;i<pcbs.length;i++){
            if(pcbs[i].getStates().equals("E")){
                a++;
            }
        }
        if(a==5){
            return true;
        }else{
            return false;
        }
    }
}
