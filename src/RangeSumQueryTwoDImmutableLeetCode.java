/**
 * Created by S N Rao on 1/20/2017.
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 *
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 */
public class RangeSumQueryTwoDImmutableLeetCode {

    public static class NumMatrix {
        int[][] mat;

        public NumMatrix(int[][] matrix) {
            if(matrix.length==0) return;
            mat=new int[matrix.length][matrix[0].length];
            mat[0][0]=matrix[0][0];
            for(int i=1;i<matrix[0].length;i++)
                mat[0][i]=mat[0][i-1]+matrix[0][i];
            for(int i=1;i<matrix.length;i++)
                mat[i][0]=mat[i-1][0]+matrix[i][0];
            for(int i=1;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    mat[i][j]=matrix[i][j]+mat[i][j-1]+mat[i-1][j]-mat[i-1][j-1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int totalSum=mat[row2][col2];
            int topSum=(row1==0)?0:mat[row1-1][col2];
            int leftSum=(col1==0)?0:mat[row2][col1-1];
            int topLeftSum=(row1==0 || col1==0)?0:mat[row1-1][col1-1];
            int answer=totalSum-topSum-leftSum+topLeftSum;
            return answer;
        }
    }

    public static void main(String args[]){
        int[][] matrix=new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}
