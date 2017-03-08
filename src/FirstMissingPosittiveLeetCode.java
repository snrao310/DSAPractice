/**
 * Created by S N Rao on 3/7/2017.
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 */
public class FirstMissingPosittiveLeetCode {

    public static int firstMissingPositive(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]<=0) nums[i]=len+1;
        }

        for(int i=0;i<len;i++){
            int abs=Math.abs(nums[i])-1;
            if(abs>len-1)continue;
            if(nums[abs]>0) nums[abs]=-nums[abs];
        }

        int i=0;
        for(i=0;i<len;i++)
            if(nums[i]>0) return i+1;
        return i+1;
    }

    public static void main(String args[]){
        System.out.print(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
