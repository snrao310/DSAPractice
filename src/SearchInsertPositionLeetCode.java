/**
 * Created by S N Rao on 12/15/2016.
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 */
public class SearchInsertPositionLeetCode {
    public static int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1;

        //Standard binary search. If only one element, low=high. That case is handled below.
        while(low<high){
            int mid=(low+high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                high=mid-1;
            else
                low=mid+1;
        }


        //low cannot be greater than high in any case.
        if(high<low)
            return high+1;

        else{           //high==low
            if(nums[high]==target)      //only one element in the array which is target.
                return high;
            else if(nums[high]>target)
                return high;
            else
                return high+1;
        }
    }

    public static void main(String args[]){
        int[] nums={1};
        System.out.print(searchInsert(nums,2));
    }
}
