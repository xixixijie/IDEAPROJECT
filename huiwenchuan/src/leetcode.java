import java.util.ArrayList;
import java.util.List;

/**
 * Created by xixi on 2018/5/1.
 */
public class leetcode {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length==0) return new ArrayList<Integer>();
        int m = matrix.length, n = matrix[0].length;
        List<Integer> spiral=new ArrayList<>();
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int flag=0;
        int l=0,r=n-1,u=0,d=m-1;
        int[] now={0,0};
        while(true){
            spiral.add(matrix[now[0]][now[1]]);
            System.out.println(matrix[now[0]][now[1]]);


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

            if(spiral.size()==m*n)
                break;

        }


        return spiral;
    }

    public static void main(String[] args) {
        int[][] matrix={
            {1, 2, 3 },
            {4, 5, 6 },
            { 7, 8, 9 }
        };
        new leetcode().spiralOrder(matrix);
    }
}
