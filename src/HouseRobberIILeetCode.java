/**
 * Created by snrao on 12/26/16.
 *
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that
 * he will not get too much attention. This time, all houses at this place are arranged in a circle. That means
 * the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the
 * same as for those in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum
 * amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobberIILeetCode {

    //Slight modification from original HouseRobber. Calls original HouseRobber function two times.
    public static int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }

    //same function as original House Robber.
    public static int rob(int[] nums,int start, int end) {
        int dp[]=new int[end-start];
        dp[0]=nums[start]; dp[1]=nums[start+1];
        for(int i=2;i<end-start;i++){
            dp[i]=Math.max(dp[i-2],dp[i-1]-nums[start+i-1])+nums[start+i];
        }

        int max=dp[0];
        for(int i:dp)
            if(i>max) max=i;
        return max;
    }

    public static void main(String args[]){
        System.out.println(rob(new int[]{0,0,0}));
    }
}
