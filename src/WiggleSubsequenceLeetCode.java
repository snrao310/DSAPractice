/**
 * Created by snrao on 12/22/16.
 *
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly
 * alternate between positive and negative. The first difference (if one exists) may be either positive or
 * negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately
 * positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because
 * its first two differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A
 * subsequence is obtained by deleting some number of elements (eventually, also zero) from the original
 * sequence, leaving the remaining elements in their original order.
 *
 */
public class WiggleSubsequenceLeetCode {

    //Greedy solution
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return nums.length;
        int count=1;
        int diff=nums[1]-nums[0];
        if(diff!=0)
            count++;
        boolean first=true;
        for(int i=2;i<nums.length;i++){
            int newDiff=nums[i]-nums[i-1];
            if(((diff>0 || (diff==0&&first)) && newDiff<0) || ((diff<0 || (diff==0&&first)) && newDiff>0)) {
                count++;
                first = false;
            }
            if(newDiff!=0)
                diff=newDiff;
        }
        return count;
    }

    public static void main(String args[]){
        System.out.println(wiggleMaxLength(new int[]{1,1,1,1,1,2,3,4,5,6,7,8,9}));
    }
}
