import org.omg.CORBA.INTERNAL;

/**
 * Created by xixi on 2018/4/9.
 */
public class Atoi {
    public int myAtoi(String str) {
        if(str.equals("")){
            return 0;
        }
        int findnum=0;
        int findflag=0;
        String numstr="";
        int flag=1;
        for(int i=0;i<str.length();i++){
            if(' '==str.charAt(i)&&findnum==0){
                if(findflag==1){
                    break;
                }
                continue;}
            else if('-'==str.charAt(i)&&findnum==0){
                if(findflag==1){
                    break;
                }
                flag=-1;
                findflag=1;
            }else if('+'==str.charAt(i)&&findnum==0){
                if(findflag==1){
                    break;
                }
                flag=1;
                findflag=1;

            } else if(Character.isDigit(str.charAt(i))){
                findnum=1;
                numstr+=str.charAt(i);
            }else{
                break;
            }
        }
        if(findnum==0){
            return 0;
        }

        int intlen=String.valueOf(Integer.MAX_VALUE).length();
        long test=0;
        if(numstr.length()>intlen){
            if(flag==1){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }else {
            test = flag * Long.parseLong(numstr);
            if(test<=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(test>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

        }
        return flag*Integer.parseInt(String.valueOf(numstr));
    }

    public static void main(String[] args) {
        Atoi ato=new Atoi();
        System.out.println(ato.myAtoi("+-2"));
    }
}
