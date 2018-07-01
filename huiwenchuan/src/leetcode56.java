import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/5/2.
 */
public class leetcode56 {
    public List<Interval> merge(List<Interval> intervals) {
        intervals=sort(intervals);
        for(int i=0;i<intervals.size();i++){
            System.out.println(intervals.get(i).start+" "+intervals.get(i).end);
        }
        find(intervals,0,intervals.size());

        for(int i=0;i<intervals.size();i++){
            System.out.println(intervals.get(i).start+" "+intervals.get(i).end);
        }

        return intervals;
    }
    void find(List<Interval> intervals,int i,int size){
        if(i==size-1){
            return;

        }


        if(intervals.get(i).start==intervals.get(i+1).start){
            if(intervals.get(i).end>intervals.get(i+1).end){
                intervals.remove(i+1);
                find(intervals,i,intervals.size());

            }else {
                intervals.remove(i);
                find(intervals,i,intervals.size());

            }
        }else{
            if(intervals.get(i).end>=intervals.get(i+1).start){
                if(intervals.get(i).end<intervals.get(i+1).end) {
                    Interval it = new Interval(intervals.get(i).start, intervals.get(i + 1).end);
                    intervals.remove(i);
                    intervals.remove(i);
                    intervals.add(i, it);
                    find(intervals, i, intervals.size());
                }else{
                    intervals.remove(i+1);
                    find(intervals,i,intervals.size());
                }
            }else{
                find(intervals,i+1,intervals.size());
            }
        }




    }

    public List<Interval> sort(List<Interval> list){
        List<Interval> newList=new ArrayList<>();
        int size=list.size();


        while (newList.size()!=size){
            int minpos=0;
            int minval=list.get(0).start;
            for(int i=0;i<list.size();i++){
                if(list.get(i).start<minval){
                    minpos=i;
                    minval=list.get(i).start;
                }
            }
            newList.add(list.get(minpos));
            list.remove(minpos);

        }

        return newList;
    }
    public static void main(String[] args) {
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(2,3));

        list.add(new Interval(4,5));
        list.add(new Interval(6,7));

        list.add(new Interval(8,9));
        list.add(new Interval(1,10));


        new leetcode56().merge(list);



    }
}
