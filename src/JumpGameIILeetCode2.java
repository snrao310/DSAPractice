/**
 * Created by S N Rao on 8/17/2017.
 */
public class JumpGameIILeetCode2 {

    public static int jump(int[] nums) {
        if(nums.length<2) return 0;
        int maxIndex=nums[0], jumps=1, noNeedToJumpTill=nums[0];
        for(int i=0;i<nums.length;i++){
            if(i>noNeedToJumpTill) {noNeedToJumpTill=maxIndex; jumps++;}
            maxIndex=Math.max(maxIndex,i+nums[i]);
        }
        return jumps;
    }

    public static void main(String args[]){
        System.out.print(jump(new int[]{2,3,1,1,4}));
    }
}
