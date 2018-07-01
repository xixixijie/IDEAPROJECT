import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/5/14.
 */
public class leetcode93 {
    public List<String> restoreIpAddresses(String s) {

        List<String> ans=new ArrayList<>();
        if(s.length()<4){
            return ans;
        }

        find(s,ans,1,"");
        return ans;
    }

    void find(String s,List<String> ans,int layer,String str) {
        if (s.length() == 0)
            return;
        if(layer==1&&s.length()>12){
            return ;
        }
        if(layer==2&&s.length()>9){
            return ;
        }
        if(layer==3&&s.length()>6){
            return ;
        }
        if(layer>4)
            return;
        if (layer == 4) {

            if(!legal(s)){
                return;
            }else{
                if(strbig255(s)){
                    return ;
                }else{
                    System.out.println(str+s);
                    ans.add(str+s);
                }
            }

        }

        String a = s.substring(0, 1);
        if (!legal(a)) {
            return;
        } else {


            find(s.substring(1), ans, layer + 1, str + a + ".");
            if(s.length()>1){
                a = s.substring(0, 2);
                if(legal(a))
                find(s.substring(2), ans, layer + 1, str + a + ".");
            }

            if(s.length()>2){
                a = s.substring(0, 3);
                if (!strbig255(a)) {
                    if(legal(a))
                    find(s.substring(3), ans, layer + 1, str + a + ".");
                }
            }

        }
    }

    boolean strbig255(String s){

        int a=Integer.parseInt(s);
        if(a>255){
            return true;
        }else
            return false;

    }
    boolean legal(String s){
        if(s.charAt(0)=='0'&&s.length()>1){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        new leetcode93().restoreIpAddresses("010010");
    }
    }
