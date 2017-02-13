/**
 * Created by S N Rao on 2/13/2017.
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 */
public class MaxConsecutiveOnesLeetCode {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0,max=0;
        for(int num:nums){
            if(num==0){
                max=Math.max(count, max);
                count=0;
            }
            else {
                count++;
            }
        }
        max=Math.max(count, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0,1,1,0,1,1,1}));
    }
}
