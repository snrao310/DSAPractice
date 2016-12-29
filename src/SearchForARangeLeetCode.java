/**
 * Created by snrao on 12/29/16.
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 */
public class SearchForARangeLeetCode {

    public static int[] searchRange(int[] nums, int target) {
        int low=0,high=nums.length-1;
        int mid=0;
        int[] result={-1,-1};
        while (low<=high){
            if(nums[low]==target){
                mid=low;
                break;
            }
            mid=(low+high)/2;
            if(nums[mid]>= target) {
                high=mid-1;
                if(high<0 || nums[high]<target)
                    break;
            }
            else low=mid+1;
        }
        if(nums[mid]!=target) return result;
        result[0]=mid;

        low=0; high=nums.length-1; mid=0;
        while (low<=high){
            if(nums[high]==target){
                mid=high;
                break;
            }
            mid=(low+high)/2;
            if(nums[mid]<=target) {
                low=mid+1;
                if(low==nums.length || nums[low]>target)
                    break;
            }
            else high=mid-1;
        }
        result[1]=mid;
        return result;
    }

    public static void main(String args[]){
        int[] nums={5, 7, 7, 8, 8, 10};
        int[] res=searchRange(nums,8);
        System.out.println(res[0]+" "+res[1]);
    }
}
