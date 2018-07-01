/**
 * Created by xixi on 2018/4/23.
 */
public class spitArray {
    public static int search(int[] nums,int target,int size){



        int left=0;
        int right=size-1;
        int center=(right-left)/2;
        while(true){

            if(target==nums[center]){
                return center;
            }else if(target==nums[left]){
                return left;
            }else if(target==nums[right]){
                return right;
            }

            if(target<nums[left]&&target>nums[right]){
                break;
            }

            if(target>nums[left]&&target<nums[center]){
                right=center;
            } else if(target>nums[left]&&target>nums[center]) {
                left=center;
            }else if(target<nums[right]&&target>nums[center]){
                left=center;
            }else if(target<nums[right]&&target<nums[center]&&nums[center]<nums[left]){
                right=center;
            }else if(target<nums[right]&&target<nums[center]&&nums[center]>nums[left]){
                left=center;
            }


            if(left==right){
                break;
            }




            center=(right+left)/2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums=new int[7];
        nums[0]=1;
        nums[1]=3;
//        nums[2]=6;
//        nums[3]=7;
//        nums[4]=0;
//        nums[5]=1;
//        nums[6]=2;

        search(nums,0,2);

    }
}
