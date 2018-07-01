/**
 * Created by xixi on 2018/4/30.
 */
public class leetcode45 {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int result=0;
        int next=0;
        int count=0;
        for(int step=0;step<nums.length;){
            count=nums[step];
            result++;
            if(count+step>=nums.length-1)break;

            int max=nums[step];
            for(int j=1;j<=count;j++){
                if(j+nums[step+j]>max){
                    next=j;
                    max=j+nums[step+j];
                }

            }
            step+=next;

        }

        return result;

    }
//
//    void find(int[] nums ,int step,int count,int[] result){
//        if(step>=nums.length-1){
//            if(count<result[0]){
//                result[0]=count;
//            }
//            return;
//        }
//        //不跳数字
//        find(nums,step+1,count+1,result);
//        //跳数字
//        int i=nums[step];
//        while(i>0){
//            find(nums,step+i,count+1,result);
//        }
//
//
//
//    }

    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(new leetcode45().jump(nums));
    }
}
