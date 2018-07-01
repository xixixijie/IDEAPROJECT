/**
 * Created by xixi on 2018/4/9.
 */
public class zhengze {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if (slen == 0 && plen == 0) return true;

        char c0 = getChar(s, 0);
        char p0 = getChar(p, 0), p1 = getChar(p, 1);

        if (match(c0, p0) || p1 == '*') {
            if (p1 != '*') {
                if (slen == 0) return false;
                return isMatch(s.substring(1), p.substring(1));
            }
            // if p1 is *, * means 0 ~ n
            int i = 0;
            boolean ret = isMatch(s.substring(0), p.substring(2)); // try 0
            if (ret) return ret;
            while (i < slen && match(getChar(s, i), p0)) {
                ret = isMatch(s.substring(i+1), p.substring(2)); // try for every available position
                if (ret) return ret;
                i++;
            }
        }

        return false;
    }

    private boolean match(char a, char b) {
        return a == b || b == '.';
    }

    private char getChar(String s, int p) {
        if (s.length() > p) {
            return s.charAt(p);
        }
        return 0;
    }

    public static void main(String[] args) {
        zhengze ze=new zhengze();
        System.out.println(ze.isMatch("aaa","a*a"));
    }
}
