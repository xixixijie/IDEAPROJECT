/**
 * Created by xixi on 2018/4/9.
 */
public class ZZZ {
    public String convert(String s, int numRows) {
        int jianju=2*(numRows-1);
        String ans="";
        int len=s.length();
        int[] visit=new int[len];
        for(int a:visit){
            a=0;
        }
        int p=0;
        for(int i=0;i<numRows;i++){
            p=0;
            while(p<len||(p+1-jianju/2)<len){
                if(i==0&&p<len){
                    ans+=s.charAt(p);
                    visit[p]=1;
                }
                if(p-i>0&&i!=0&&p-i<len){
                    if(visit[p-i]==0) {
                        ans += s.charAt(p - i);
                        visit[p-i] = 1;
                    }

                }
                if(p+i<s.length()&&i!=0&&p-i<len){
                    if(visit[p+i]==0) {
                        ans += s.charAt(p + i);
                        visit[p+i] = 1;
                    }
                }
                p+=jianju;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ZZZ zzz=new ZZZ();

        System.out.println(zzz.convert("ABCD",3));
    }
}
