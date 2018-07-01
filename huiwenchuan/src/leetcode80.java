/**
 * Created by xixi on 2018/5/11.
 */
public class leetcode80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){//长度小于2，直接返回
            return nums.length;
        }

        boolean isTwice = false;//是否两次
        int len = 0;//最新长度
        for(int i = 0; i < nums.length; i++){//遍历
            //不等于最后一个切数字相等
            if(i != nums.length -1 && nums[i+1] == nums[i]){
                if(!isTwice){//还没两次
                    isTwice = true;
                    nums[len++] = nums[i];  //添加到数组最前
                }
            }else{//不相等
                isTwice = false;//标记为不是两次
                nums[len++] = nums[i];//添加最前
            }
        }
        return len;

    }

    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,1,2,3,3};
        new leetcode80().removeDuplicates(nums);
    }
}
