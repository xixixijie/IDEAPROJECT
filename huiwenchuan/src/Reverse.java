/**
 * Created by xixi on 2018/4/9.
 */
public class Reverse {


    public int reverse(int x) {
        String s=""+x;
        if(x>=0){
            s=daozhi(s);
        }else{
            s="-"+daozhi(s.substring(1,s.length()));
        }
        long num=Long.parseLong(s);
        if(num>Integer.MAX_VALUE||num<Integer.MIN_VALUE){
            return 0;
        }

        return Integer.parseInt(s);
    }
    public String daozhi(String s){
        String newstr="";
        for(int i=s.length()-1;i>-1;i--){
            newstr+=s.charAt(i);
        }
        return newstr;
    }

    public static void main(String[] args) {
        Reverse re=new Reverse();
        System.out.println(re.reverse(-2147483648));
    }
}
