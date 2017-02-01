/**
 * Created by S N Rao on 1/31/2017.
 */
public class SearchInRotatedSortedArrayIILeetCode {

    //WorstCase O(n). Average case O(logn).
    public static int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]==nums[high] && nums[high]==nums[mid])
                high--;
            else if(nums[mid]>=nums[low]){
                if(nums[low]<=target && nums[mid]>target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else if(nums[mid]<nums[low]){
                if(nums[mid]<target && nums[high]>=target)
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.println(search(new int[]{4,4,4,4,6,7,8,1,2,2,3,4,4},1));
    }
}
