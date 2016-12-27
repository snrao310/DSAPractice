/**
 * Created by snrao on 12/26/16.
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security
 * system connected and it will automatically contact the police if two adjacent houses were broken into on the
 * same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobberLeetCode {

    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0]; dp[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-2],dp[i-1]-nums[i-1])+nums[i];
        }
        int max=dp[0];
        for(int i:dp)
            if(i>max) max=i;
        return max;
    }

    public static void main(String args[]){
        System.out.println(rob(new int[]{1,2}));
    }
}
