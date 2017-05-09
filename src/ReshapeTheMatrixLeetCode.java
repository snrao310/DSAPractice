/**
 * Created by S N Rao on 5/9/2017.
 *
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different
 * size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row
 * number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order
 * as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 *
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the
 * previous list.
 *
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 *
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 *
 */
public class ReshapeTheMatrixLeetCode {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length, n=nums[0].length;
        if(m*n != r*c) return nums;
        int[][] res=new int[r][c];

        int k=0,l=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[k][l]=nums[i][j];
                l=(l+1)%c; if(l==0) k++;
            }
        }
        return res;
    }

    public static void main(String args[]){
        int[][] res=matrixReshape(new int[][]{{1,2,3},{4,5,6}},3,2);
        for(int[] arr:res){
            for(int i:arr)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
