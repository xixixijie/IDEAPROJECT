import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/4/30.
 */
public class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  result=new ArrayList<>();
        if(nums.length==0)
            return result;
        List<Integer> visit=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            visit.add(0);


        List<Integer> ans=new ArrayList();
        find(nums,visit,ans,result);

        return result;
    }

    void find(int[] nums,List visit,List<Integer> ans,List<List<Integer>> result){
        List<Integer> nVisit=new ArrayList<>();
        List<Integer> nAns=new ArrayList<>();
        nVisit.addAll(visit);
        nAns.addAll(ans);
        if(nAns.size()==nums.length) {
            result.add(ans);

            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i));


            }
            System.out.println();
            return ;
        }
        for(int i=0;i<nums.length;i++){

            if(visit.get(i)==0){
                nAns.add(nums[i]);

                nVisit.set(i,1);
                find(nums,nVisit,nAns,result);
                nAns.remove(nAns.size()-1);
                nVisit.set(i,0);
            }

        }

    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new leetcode46().permute(nums).size());
    }
}
