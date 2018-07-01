/**
 * Created by xixi on 2018/5/12.
 */
public class leetcode81 {
    public boolean search(int[] nums, int target) {
        if(nums.length==0)
            return false;
        int begin=0;
        int end=nums.length-1;
        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target)
                return true;
            if(nums[begin]==target)
                return true;
            if(nums[end]==target)
                return true;
            if(nums[mid]>=nums[begin]){

                if(nums[begin]<=target&&target<nums[mid])
                    end=mid-1;
                else
                    begin=mid+1;
            }else{   //此时mid处于第二个递增数组 begin处于第一个递增数组 自然的mid和end肯定处于第二个递增数组上

                if(nums[mid]<target&&target<=nums[end])
                    begin=mid+1;
                else
                    end=mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num={1,3,1,1,1};
        new leetcode81().search(num,3);
    }
}
