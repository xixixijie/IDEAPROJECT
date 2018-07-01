import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/5/14.
 */
public class leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans=new ArrayList<>();
        ans.add(0);
        ans.add(1);

        if(n==0){
            return ans;
        }
        for(int i=1;i<n;i++){
            int size=(int)Math.pow(2,i);
            int add=(int)Math.pow(2,i);
            while(size>0){
                ans.add(ans.get(size-1)+add);
                size--;
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        new leetcode89().grayCode(2);
    }
}
