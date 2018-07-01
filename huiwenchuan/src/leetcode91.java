import java.util.HashSet;
import java.util.Set;

/**
 * Created by xixi on 2018/5/14.
 */
public class leetcode91 {
    int ans;
    public int numDecodings(String s) {
        Set<String> set=new HashSet<>();
        for(int i=1;i<27;i++){
            set.add(i+"");
        }
        int ans=0;
        find(set,s);

        return ans;
    }

    void find(Set<String> set,String s){
        if(s.length()==0){
            ans++;
            return;
        }
        if(s.length()>1){
            String a=""+s.charAt(0)+s.charAt(1);
            if(set.contains(a)){
                find(set,s.substring(2));
            }
        }
        if(s.length()>0){
            String a=""+s.charAt(0);
            if(set.contains(a)){
                find(set,s.substring(1));
            }
        }

    }

    public static void main(String[] args) {
        new leetcode91().numDecodings("8299152987184352183335613793611738246622952882892165423687431814339833963464637792247791375416898193");
    }
}
