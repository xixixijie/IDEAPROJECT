/**
 * Created by xixi on 2018/5/10.
 */
public class leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int i=0;
        int j=matrix.length-1;
        int mid=(i+j)/2;
        while(true){
            if(target==matrix[mid][0])
                return true;
            if(i==j)
                break;
            if(target>matrix[mid][0])
                i=mid;
            if(target<matrix[mid][0])
                j=mid-1;

            mid=(i+j)/2;

        }

        int m=0;
        int n=matrix[0].length-1;
        mid=(m+n)/2;
        while(true){
            if(target==matrix[i][mid])
                return true;
            if(m==n)
                break;

            if(target>matrix[i][mid])
                m=mid+1;
            if(target<matrix[i][mid])
                n=mid-1;

            mid=(m+n)/2;

        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        new leetcode74().searchMatrix(matrix,11);
    }
}
