import java.util.Arrays;

/**
 * Created by S N Rao on 3/2/2017.
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 6.
 *
 */
public class MaximalRectangleLeetCode {

    //DP solution. 2D dp reduced to 1d coz only previous row is needed. left(i,j) is leftmost 1 position in current
    //stream of 1s (smallest of this and upper row).
    //right(i,j) is rightmost 1 position in current stream of 1s (smallest of this and upper row).
    // height(i,j) is longest vertical stream of 1s till here.
    //
    // left(i,j) = max(left(i-1,j), cur_left), cur_left can be determined from the current row
    // right(i,j) = min(right(i-1,j), cur_right), cur_right can be determined from the current row
    // height(i,j) = height(i-1,j) + 1, if matrix[i][j]=='1';
    // height(i,j) = 0, if matrix[i][j]=='0'
    //
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m=matrix.length,n=matrix[0].length, maxArea=0;
        int[] height=new int[n],left=new int[n],right=new int[n];
        Arrays.fill(right,n);

        for(int i=0;i<m;i++){
            int curLeft=-1, curRight=n;
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') left[j]=Math.max(left[j],curLeft);
                else{
                    curLeft=j+1;
                    left[j]=0;
                }
            }

            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1') right[j]=Math.min(right[j],curRight);
                else{
                    curRight=j;
                    right[j]=n;
                }
            }

            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') height[j]++;
                else height[j]=0;
            }

            for(int j=0;j<n;j++){
                maxArea=Math.max(maxArea, (right[j]-left[j])*height[j]);
            }
        }
        return maxArea;
    }

    public static void main(String args[]){
//        System.out.print(maximalRectangle(new char[][]{{'1','0'}}));
        System.out.print(maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
