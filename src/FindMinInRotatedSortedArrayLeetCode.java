/**
 * Created by S N Rao on 12/16/2016.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element. You may assume no duplicate exists in the array.
 *
 */

public class FindMinInRotatedSortedArrayLeetCode {

    //Binary search modification.
    public static int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        if(nums[low]<nums[high])
            return nums[0];

        while(low<=high){
            if(high-low <= 1)
                return nums[high];

            int mid=(low+high)/2;
            if(nums[mid]<nums[low])
                high=mid;
            else if(nums[mid]>nums[low])
                low=mid;
        }
        return -1;
    }

    public static void main(String args[]){
        int nums[]={ 1};
        System.out.print(findMin(nums));
    }
}
