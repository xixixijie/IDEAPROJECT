/**
 * Created by xixi on 2018/4/29.
 */
public class leetcode44 {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        p=simplize(p);
        int plen = p.length();

        if (slen == 0 && plen == 0) return true;
        if(plen==0) return false;
        //if(slen==0&& plen!=0)return false;
        char s0 = getchar(s,0);
        char p0 = getchar(p,0);

        if(p0!='*'){
            if(Match(s0,p0)){
                if(slen==0) return false;
                return isMatch(s.substring(1),p.substring(1));
            }

        }else{
            int i=0;
            boolean ret = isMatch(s.substring(0), p.substring(1)); // try 0
            if(ret) return ret;
            while(i<slen){
                ret=isMatch(s.substring(i+1),p.substring(1));
                if(ret) return ret;
                i++;
            }

        }

        return false;
    }

    boolean Match(char a,char b){
        return a==b||b=='?';
    }

    String simplize(String p){
        String newstr="";
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)!='*')
                newstr+=p.charAt(i);
            else{
                if(i==p.length()-1)
                    newstr+=p.charAt(i);
                else if(p.charAt(i+1)=='*')
                    continue;
                else
                    newstr+=p.charAt(i);
            }
        }
        return newstr;
    }

    char getchar(String s,int i){
        if (s.length() > i) {
            return s.charAt(i);
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new leetcode44().isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb"
//                ,"b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));

        System.out.println(new leetcode44().simplize("b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));
    }
}
