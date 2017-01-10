/**
 * Created by S N Rao on 1/10/2017.
 *
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 */
public class MinimumSizeSubarraySumLeetCode {

    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;

        int result=0;
        int sum=nums[0],size=1,i=0,j=0;
        while (true){
            if(sum>=s){
                if(size<result || result==0) result=size;
                sum-=nums[i];i++;size--;
            }
            else if(j==nums.length-1)
                break;
            else{
                j++;sum+=nums[j];size++;
            }
        }

        return result;
    }

    public static void main(String args[]){
        System.out.print(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
