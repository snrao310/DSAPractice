/**
 * Created by S N Rao on 4/10/2017.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 */
public class ClimbingStairsLeetCode {

    public static int climbStairs(int n) {
        if(n==0 || n==1) return n;
        int[] dp=new int[n];
        dp[n-1]=1; dp[n-2]=2;
        for(int i=n-3;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        return dp[0];
    }

    public static void main(String args[]){
        System.out.print(climbStairs(6)); //13
    }
}
