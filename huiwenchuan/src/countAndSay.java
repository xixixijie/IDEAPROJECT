/**
 * Created by xixi on 2018/4/24.
 */
public class countAndSay {
    public static String  count(int n){
        String str="1";


        for(int i=1;i<n;i++){
            str=nextStr(str);

        }

        return str;
    }

    public static String nextStr(String str){
        String newstr="";
        char c;
        int num=0;
        for(int i=0;i<str.length();i++){

            c=str.charAt(i);

            if(c==str.charAt(i)){
                num++;
            }

            if(i==str.length()-1||c!=str.charAt(i+1)){
                newstr=newstr+num+c;
                num=0;
            }

        }
        return newstr;
    }

    public static void main(String[] args) {
        System.out.println(count(4));
    }
}
