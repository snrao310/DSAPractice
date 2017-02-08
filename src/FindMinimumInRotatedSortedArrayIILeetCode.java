/**
 * Created by S N Rao on 2/8/2017.
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 */
public class FindMinimumInRotatedSortedArrayIILeetCode {

    //WorstCase O(n). Average case O(logn).
    public static int findMin(int[] nums) {
        int low=0,high=nums.length-1,mid=0;
        while(low<=high){
            mid=low+(high-low)/2;
            if(mid>0 && nums[mid-1]>nums[mid])return nums[mid];
            if(nums[low]<nums[high]) return nums[low];
            if(nums[mid]>nums[low]) low=mid+1;
            else if(nums[mid]<nums[low]) high=mid-1;
            else low++;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,6,6,6,7,8,1,2,3,3,3,4}));
    }
}