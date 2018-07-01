import java.util.Random;

/**
 * Created by xixi on 2017/12/7.
 */
public class AntiEntro {
    static long acount=0;
    public static void main(String[] args) {
        int Size = 1000;
        double[] datas = new double[Size];
        for (int i = 0; i < Size; i++) {
            //datas[i] = i;

            datas[i]=new Random().nextDouble()*Size;
        }
        while (true) {
            for (int i = 0; i < Size; i++) {
                for (int j = 0; j < Size; j++) {
                    if (i == j)
                        continue;
                    else {
                        System.out.println(datas[i]+":"+datas[j]);
                        acount++;

                            datas[i]=exchange(datas[i],datas[j]);
                            datas[j]=datas[i];


                    }

                }

            }

            if(quit(datas)){
                break;
            }

        }

        System.out.println("所有节点共交谈了"+acount+"次");
        System.out.println("误差：这里用的是整数部分相等即相等，误差0.1");
    }


    public static double exchange(double n1, double n2) {
        double avg = (n1 + n2)/2.0;
        //acount++;
        return avg;
    }
    //X整数部分相同则相同
    public static boolean quit(double[] datas){
        boolean flag=true;
        int avg=(int)datas[0];
        //System.out.println(avg);
        for(double data:datas){
            // System.out.println((int)data+":"+avg);
            if((int)data!=avg){
                flag=false;
            }
        }

        return flag;
    }
}
