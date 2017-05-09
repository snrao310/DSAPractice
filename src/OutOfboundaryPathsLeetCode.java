import java.util.Arrays;

/**
 * Created by S N Rao on 5/7/2017.
 *
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent
 * cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times.
 * Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after
 * mod 109 + 7.
 *
 * Example 1:
 * Input:m = 2, n = 2, N = 2, i = 0, j = 0
 * Output: 6
 *
 * Example 2:
 * Input:m = 1, n = 3, N = 3, i = 0, j = 1
 * Output: 12
 *
 * Note:
 * Once you move the ball out of boundary, you cannot move it back.
 * The length and height of the grid is in range [1,50].
 * N is in range [0,50].
 *
 */
public class OutOfboundaryPathsLeetCode {

    //dp[N][i][j]=number of paths from cell (i,j) with maximum N steps allowed. Now, this depends on 4 neighboring cells
    //values when the minimum steps allowed was N-1 i.e. dp[N] of cell (i,j) depends only on dp[N-1] of its neighboring
    //cells. So since dp[N] depends only on dp[N-1] we can remove this dimension and maintain dp values for each cell
    //and update them for each N value. Complexity is thus O(N* m*n).
    public static int findPaths(int m, int n, int N, int p, int q) {
        if(N<1) return 0;
        int mod=1000000007;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++) {dp[i][0]++;dp[i][n-1]++;}
        for(int i=0;i<n;i++) {dp[0][i]++;dp[m-1][i]++;}
        int singleMoves[][]= Arrays.copyOf(dp,m);
        for(int k=2;k<=N;k++){
            int dpNew[][]=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    dpNew[i][j]= (((((i>0)?dp[i-1][j]:0) + ((i<m-1)?dp[i+1][j]:0))%mod + ((j>0)?dp[i][j-1]:0))%mod + ((j<n-1)?dp[i][j+1]:0))%mod;
                    dpNew[i][j]=(dpNew[i][j]+singleMoves[i][j])%mod;
                }
            }
            dp=dpNew;
        }
        return dp[p][q];
    }

    public static void main(String args[]){
        System.out.println(findPaths(2,2,2,0,0));//6
        System.out.println(findPaths(1,3,3,0,1));//12
    }
}
