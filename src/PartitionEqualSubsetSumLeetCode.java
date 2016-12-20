/**
 * Created by snrao on 12/20/16.
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSumLeetCode {

    //Dynamic programming same as knapsack but without maximizing values (just boolean)
    public static boolean canPartition(int[] nums) {
        if(nums.length==0)  //edgecase
            return true;

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {     //In knapsack, total sum would be the max allowed weight, and nums[] would be
            totalSum += nums[i];                    // a weight[] array. There would also be a value[] array containing values we
        }                                           // trying to maximize.

        if (totalSum % 2 != 0)
            return false;
        totalSum /= 2;

        boolean dp[][] = new boolean[nums.length + 1][totalSum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= totalSum; j++) {
                if(j >= nums[i - 1])                                            //this step in knapsack would be
                    dp[i][j] = dp[i - 1][j] ||  dp[i - 1][j - nums[i - 1]];     // dp[i][j]=max(value[i]+dp[i-1][j-weight[i]],dp[i-1][j])
                                                                                //if condition to check if j>=weight[i].
                else
                    dp[i][j]=dp[i-1][j];    //same in knapsack;
            }
        }
        return dp[nums.length][totalSum];
    }

    public static void main(String args[]) {
        System.out.print(canPartition(new int[]{1, 5, 11, 5}));
    }
}
