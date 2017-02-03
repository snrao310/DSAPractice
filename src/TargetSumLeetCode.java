import java.util.Arrays;

/**
 * Created by S N Rao on 2/2/2017.
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 */
public class TargetSumLeetCode {

    public static int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for(int i:nums)sum+=i;
        if(Math.abs(S)>Math.abs(sum)) return 0;
        int[][] dp=new int[nums.length][2*sum+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return backTrackFunction(nums,dp,0,S);
    }

    private static int backTrackFunction(int[] nums, int[][] dp, int start,int sum){
        if(start==nums.length) {
            if(sum==0)return 1;
            else return 0;
        }

        if(dp[start][Math.abs(sum)]!=-1) return dp[start][Math.abs(sum)];

        int ways=0;
        ways+=backTrackFunction(nums,dp,start+1,sum-nums[start]);
        ways+=backTrackFunction(nums,dp,start+1,sum+nums[start]);
        dp[start][Math.abs(sum)]=ways;
        return ways;
    }

    public static void main(String args[]){
        System.out.print(findTargetSumWays(new int[]{1,2,7,9,981},1000000000));
    }
}
