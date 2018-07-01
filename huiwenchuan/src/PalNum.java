/**
 * Created by xixi on 2018/4/9.
 */
public class PalNum {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int div=1;
        while(x/div>=10){
            div*=10;
        }



        return true;
    }
}
