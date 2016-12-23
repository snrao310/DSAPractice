/**
 * Created by snrao on 12/22/16.
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 */
public class PerfectSquaresLeetCode {

    public static int numSquares(int n) {
        int result=0;
        int[] dp=new int[n+1];
        dp[0]=0;dp[1]=1;
        return topDownDP(n,dp); //can also go for bottom up here;
    }

    public static int topDownDP(int n, int[] dp){
        if(dp[n]!=0 || n==0)
            return dp[n];
        int k=(int)Math.sqrt(n);
        int smallerSquare=k*k;
        int min=n;
        for(int i=1;i*i<=n;i++){
            if(1+topDownDP(n-(i*i),dp)<min)
                min=1+topDownDP(n-(i*i),dp);
        }
        dp[n]=min;
        return dp[n];
    }

    public static void main(String args[]){
        System.out.println(numSquares(13));
    }

}
