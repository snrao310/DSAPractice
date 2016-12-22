import java.util.Arrays;

/**
 * Created by snrao on 12/21/16.
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroesLeetCode {

    //Can do it in O(m+n) space also (better than naive O(n^2) space), but this is just brilliant.
    // Only key challenge is when either first row or first column has a 0, matrix[0][0] is set.
    // So for either first row or first column, calculation should be done separately.
    public static void setZeroes(int[][] matrix) {
        boolean isrow0=false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i==0 && matrix[i][j]==0) isrow0=true;    //checking if anything in first row is 0
                if (matrix[i][j] == 0 && i!=0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length-1; i >=1; i--)       //need to fill backwards because. Won't work otherwise.
            for (int j =matrix[i].length-1; j >=0;j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        if(isrow0)
            Arrays.fill(matrix[0],0);       //making first row zeroes if any element in the row was 0.
    }

    public static void main(String args[]) {
        int[][] mat = {{1,2,3,4},{5,0,5,2},{1,1,1,4},{1,2,1,3},{1,1,1,1}};
        setZeroes(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
