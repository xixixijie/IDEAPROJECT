import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/5/7.
 */
public class leetcdoe60 {
    public String getPermutation(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(i+1);

        }
        String ans="";
        if(n==0)
            return ans;
        while(n>0){
            int div=fac(n-1);

            int a=k/div;
            ans+=nums.get(a);
            nums.remove(a);
            k=k%div;
            n--;

        }



        return ans;
    }

    int fac(int n){
        if(n<0) return 0;
        if(n==0||n==1)return 1;
        if(n>1)
        {
            return n*fac(n-1);
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new leetcdoe60().getPermutation(3,2));
    }
}