/**
 * Created by snrao on 10/29/16.
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 */
public class CountNumbersWithUniqueDigitsLeetCode {

    //counts number of numbers with unique digits between 0 and 10^n.
    // Uses permutations and dynamic programming.
    public static int countNumbersWithUniqueDigits(int n) {
        if(n>11)
            return 0;

        if(n==0) return 1;
        if(n==1) return 10;
        if(n==2) return 91;

        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=10;
        dp[2]=91;

        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]-dp[i-2])*(11-i) + dp[i-1];
        }

        return dp[n];
    }


    public static void main(String args[]) {
        int k=countNumbersWithUniqueDigits(3);
        System.out.print(k);
    }
}
