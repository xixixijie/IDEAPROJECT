/**
 * Created by xixi on 2018/4/26.
 */
public class solution {
    public static int trap(int[] height) {
//        if(height.size()<2)
//            return 0;

        int h1,h2;
        int sum=0;
        h1=0;

        for(int i=1;i<height.length;i++){

            h2=i;

            int area;
            if(height[i]>=height[h1]){
                area=(h2-h1)*height[h1];
                for(int j=h1;j<h2;j++){
                    area-=height[j];
                }
            }else{
                area=(h2-h1)*height[h2];
                for(int j=h2;j>h1;j--)
                    area-=height[j];
            }



            if(height[h2]>height[h1]){
                h1=h2;
            }
            if(area>0){
                sum+=area;
                h1=h2;

            }


        }

        return sum;
    }


    public static void main(String[] args) {
        int[] a={0,1,0,2,1,0,1,3,2,1,2,1};
        trap(a);
    }
}
