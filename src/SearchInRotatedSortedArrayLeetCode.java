/**
 * Created by S N Rao on 1/27/2017.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 */
public class SearchInRotatedSortedArrayLeetCode {

    public static int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[low]){
                if(nums[mid]>target && target>=nums[low])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else{
                if(nums[mid]<target && target<=nums[high])
                    low=mid+1;
                else
                    high=mid-1;

            }
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.println(search(new int[]{1,3,5},1));
    }
}
