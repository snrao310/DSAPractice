/**
 * Created by snrao on 12/17/16.
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 */
public class IncreasingTripletSubsequenceLeetCode {

    //basically have to find first 3 minimum canditates in left to right order
    public static boolean increasingTriplet(int[] nums) {

        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE,min3=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<=min1)
                min1=nums[i];
            else if(nums[i]<=min2)
                min2=nums[i];
            else if(nums[i]<=min3)
                return true;
        }
        return false;

    }

    public static void main(String args[]){
        System.out.print(increasingTriplet(new int[]{1,2,0,3}));
    }
}
