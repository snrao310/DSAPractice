import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 1/19/2017.
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 *
 */
public class SpiralMatrixLeetCode {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0) return list;
        int s1=0,e1=matrix[0].length-1;
        int s2=1,e2=matrix.length-1;
        int currlen=0,len=matrix.length*matrix[0].length,k=0;
        boolean forward=true;
        while(currlen!=len){
            int i=s1;
            while((i>=s1 && i<=e1)||(i<=s1 && i>=e1)){
                list.add(matrix[k][i]);
                currlen++;
                i=(forward)?i+1:i-1;
            }
            k=e1;
            e1=(forward)?e1-1:e1+1;
            int temp=e1;e1=s1;s1=temp;
            if(currlen==len) break;

            i=s2;
            while((i>=s2 && i<=e2) || (i<=s2 && i>=e2)){
                list.add(matrix[i][k]);
                currlen++;
                i=(forward)?i+1:i-1;
            }
            k=e2;
            e2=(forward)?e2-1:e2+1;
            temp=e2;e2=s2;s2=temp;
            forward=!forward;
        }
        return list;
    }

    public static void main(String args[]){
        List<Integer> list=spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},
                {11,12,13,14,15},{16,17,18,19,20}});
        for(int i:list)
            System.out.print(i+" ");
    }
}
