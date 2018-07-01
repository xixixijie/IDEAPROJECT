/**
 * Created by xixi on 2018/5/1.
 */
public class leetcode47 {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }

        int next=0;
        int count=0;
        for(int step=0;step<nums.length;){
            count=nums[step];
            if(count==0) break;

            if(count+step>=nums.length-1)   return true;

            int max=nums[step];
            for(int j=1;j<=count;j++){
                if(j+nums[step+j]>=max){
                    next=j;
                    max=j+nums[step+j];
                }

            }
            step+=next;

        }

        return false;
    }

    public static void main(String[] args) {
        int[] num={3,2,1,0,4};

        new leetcode47().canJump(num);
    }
}
