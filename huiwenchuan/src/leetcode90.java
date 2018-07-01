import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/5/14.
 */
public class leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, nums, 0);
        System.out.println(res.size());
        removeSame(res);

        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        res.add(new ArrayList<Integer>(temp));
        for(int i = j; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            dfs(res, temp, nums, i + 1);  //
            temp.remove(temp.size() - 1);  //
        }
    }

    private void removeSame(List<List<Integer>> res){
        for(int i=0;i<res.size()-1;i++){
            for(int j=i+1;j<res.size();j++){
                if(isSame(res.get(i),res.get(j))){
                    res.remove(j);
                    j--;
                }
            }
        }

    }

    private boolean isSame(List<Integer> a,List<Integer> b){
        if(a.size()!=b.size())
            return false;
        boolean[] visti=new boolean[a.size()];
        for(int i=0;i<a.size();i++){
            int j;
            for(j=0;j<b.size();j++){
                if(a.get(i)==b.get(j)&&visti[j]==false){
                    visti[j]=true;
                    break;
                }
            }
            if(j==b.size()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={1,2,2};

        new leetcode90().subsetsWithDup(nums);
    }
}
