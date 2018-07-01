import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/5/3.
 */
public class leetcode57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()==0){
            intervals.add(newInterval);
            return intervals;
        }

        int i=0;
        while(true){
            //合并
            if(intervals.get(i).end>=newInterval.start&&intervals.get(i).start<=newInterval.end){

                int start=intervals.get(i).start<newInterval.start?intervals.get(i).start:newInterval.start;
                int end=intervals.get(i).end>newInterval.end?intervals.get(i).end:newInterval.end;
                intervals.remove(i);



                    while(true){
                        if(intervals.size()-i==0)
                            break;
                        if(newInterval.end>=intervals.get(i).start){
                            end=intervals.get(i).end>end?intervals.get(i).end:end;
                            intervals.remove(i);
                        }else{
                            break;
                        }





                    }

                Interval it=new Interval(start,end);

                intervals.add(i,it);
                break;

            }
            //插入
            else{

                    if(newInterval.end<intervals.get(i).start){
                        intervals.add(i,newInterval);
                        break;
                    }
                    if(i==intervals.size()-1){
                        intervals.add(newInterval);
                        break;
                    }

                    if(intervals.get(i+1).start>newInterval.end) {
                        intervals.add(i+1,newInterval);
                        break;
                    }



            }
            i++;


        }

        return intervals;

    }

    public static void main(String[] args) {
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(0,2));
//
        list.add(new Interval(3,9));
//        list.add(new Interval(8,11));

//        list.add(new Interval(8,10));
//        list.add(new Interval(12,16));



        new leetcode57().insert(list,new Interval(6,8));
    }
}
