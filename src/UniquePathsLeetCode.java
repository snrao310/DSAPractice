import java.util.Arrays;

/**
 * Created by S N Rao on 12/15/2016.
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class UniquePathsLeetCode {

    //Bottom up dynamic programming.
    public static int uniquePaths(int m, int n) {
        int[][] dynamicMatrix=new int[m][n];

        //Initialize first horizontal and vertical columns to 1;
        Arrays.fill(dynamicMatrix[0],1);
        for(int i=0;i<m;i++){
            dynamicMatrix[i][0]=1;
        }

        //Filling the dynamic programming matrix.
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dynamicMatrix[i][j]=dynamicMatrix[i-1][j]+dynamicMatrix[i][j-1];
            }
        }
        return dynamicMatrix[m-1][n-1];
    }

    public static void main(String args[]){
        System.out.print(uniquePaths(3,4));
    }
}
