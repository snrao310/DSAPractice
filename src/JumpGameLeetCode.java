/**
 * Created by snrao on 1/2/17.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 */
public class JumpGameLeetCode {

    public static boolean canJump(int[] nums) {
        int max=nums[0];
        for(int i=0;i<=max;i++){
            if(max>=nums.length-1) return true;
            max=Math.max(max, i+nums[i]);
        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(canJump(new int[]{2,3,1,1,4}));
    }
}
