package Done;

/**
 * Created by snrao on 12/21/16.
 *
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 */
public class FindPeakElementLeetCode {

    //Binary search to find local maximum.
    public static int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;

        while (low<=high){
            int mid=(low+high)/2;
            int before,after;
            if(mid==0) before=Integer.MIN_VALUE;
            else before=nums[mid-1];
            if(mid==nums.length-1) after=Integer.MIN_VALUE;
            else after=nums[mid+1];

            if((before<nums[mid] ||before==Integer.MIN_VALUE) && (nums[mid]>after || after==Integer.MIN_VALUE))
                return mid;

            if(before>nums[mid])
                high=mid-1;
            else
                low=mid+1;

        }

        return -1;
    }


    public static void main(String args[]){
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }
}
