
/**
 * Created by S N Rao on 3/3/2017.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last
 * index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 *
 */
public class JumpGameIILeetCode {

    public static int jump(int[] nums) {
        if(nums.length<2) return 0;
        int maxInd=0, lastJumpMax=0, jumps=0;
        for(int i=0;i<nums.length;i++){
            if(i>lastJumpMax){
                lastJumpMax=maxInd;
                jumps++;
            }
            maxInd=Math.max(maxInd,i+nums[i]);
        }
        return jumps;
    }

    public static void main(String args[]){
        System.out.print(jump(new int[]{2,3,1,1,4}));
    }
}
