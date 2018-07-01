/**
 * Created by xixi on 2018/4/8.
 */
public class Sulotion {
    private  String ans;

    private  int maxLen=0;//回文子串的最大长度
    public String longestPalindrome(String s) {

        int len=s.length();
        if(len<2) return s;
        for(int i=0;i<len;i++){
            extendPalindrome(s,i,i);//回文子串是奇数的情况
            extendPalindrome(s,i,i+1);//回文子串是偶数的情况
        }
        return ans;
    }
    private  void extendPalindrome(String s, int j, int k) {
        while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k)){
            if(maxLen<k-j+1){
                maxLen=k-j+1;
                ans=s.substring(j,k+1);
            }
            j--;
            k++;
        }

    }

    public static void main(String[] args) {
        Sulotion s=new Sulotion();
        System.out.println(s.longestPalindrome("cbba"));
    }
}
