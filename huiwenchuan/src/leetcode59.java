/**
 * Created by xixi on 2018/5/7.
 */
public class leetcode59 {
    public int[][] generateMatrix(int n) {
        int[][] spiral=new int[n][n];
        if(n==0) return spiral;
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int flag=0;
        int l=0,r=n-1,u=0,d=n-1;
        int[] now={0,0};
        int num=1;
        while(num<=n*n){
            spiral[now[0]][now[1]]=num;
            num++;


            //走右尽头
            if(now[1]==r&&flag==0){
                flag=(flag+1)%4;
                r--;
            }
            //下尽头
            if(now[0]==d&&flag==1){
                flag=(flag+1)%4;
                d--;
            }
            //左尽头
            if(now[1]==l&&flag==2){
                flag=(flag+1)%4;
                l++;
            }
            //上尽头
            if(now[0]==u+1&&flag==3){
                flag=(flag+1)%4;
                u++;
            }
            now[0]+=dir[flag][0];
            now[1]+=dir[flag][1];



        }


        return spiral;
    }

    public static void main(String[] args) {
        new leetcode59().generateMatrix(3);
    }

}
