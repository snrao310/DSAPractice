/**
 * Created by S N Rao on 12/16/2016.
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 *
 */
public class SpiralMatrixIILeetCode {

    public static int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int colStart=1,colEnd=n-1,prev_colEnd=0;
        int rowStart=0,rowEnd=n-1,prev_rowEnd=n-1;
        int num=0,max=n*n;
        int oddEven=1;
        while(num<max){
            //fill direction for next iteration, first right then left/ first down then up.
            oddEven*=-1;

            //filling row.
            int i=rowStart;
            while((i<=rowEnd && i>=rowStart) || (i>=rowEnd && i<=rowStart)){
                num++;
                result[prev_colEnd][i]=num;
                if(rowEnd>rowStart)
                    i++;
                else
                    i--;
            }

            if(num>=max)
                break;

            //setting row range for next iteration.
            prev_rowEnd=rowEnd;
            rowEnd=rowStart;
            rowStart=prev_rowEnd + oddEven;


            //filling column
            int j=colStart;
            while((j<=colEnd && j>=colStart) || (j>=colEnd && j<=colStart)){
                num++;
                result[j][prev_rowEnd]=num;
                if(colEnd>colStart)
                    j++;
                else
                    j--;
            }

            //setting column range for next iteration
            prev_colEnd=colEnd;
            colEnd=colStart;
            colStart=prev_colEnd + oddEven;
        }
        return result;
    }



    public static void main(String args[]){
        int mat[][]=generateMatrix(3);
        for(int m[]: mat){
            for(int i:m){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
