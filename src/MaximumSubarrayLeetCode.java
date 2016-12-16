/**
 * Created by S N Rao on 12/16/2016.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 */
public class MaximumSubarrayLeetCode {

    //Dynamic programming. Bottom up.
    public static int maxSubArray(int[] nums) {

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max=dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = ((nums[i] + dp[i - 1]) > nums[i]) ? (nums[i] + dp[i - 1]) : nums[i];
            //the above line is same as dp[i] = ((dp[i - 1]) > 0) ? (nums[i] + dp[i - 1]) : nums[i]; but more intuitive.
            if(dp[i]>max)
                max=dp[i];
        }

        return max;
    }

    public static void main(String args[]) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(nums));
    }
}
