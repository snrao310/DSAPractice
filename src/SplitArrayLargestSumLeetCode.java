/**
 * Created by S N Rao on 2/13/2017.
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 *
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 *
 */
public class SplitArrayLargestSumLeetCode {


    //Binary search based logic. Very non-intuitive.
    //Logic is that the minimum sum possible is the maximum element of the array (when it is alone in a subarray). The
    //maximum sum is sum of all elements in the list (when there is only one subarray). So the answer mucst be in between
    //these two values. So do binary search with max element as low and sum of all elements as high and check which is
    //get to the correct value.
    //To check if a target value is lower than answer or greater than answer, we traverse the array and create a new split
    //whenever the sum of elements in the split reaches more than the target value. If m splits are over and there are
    //elements remaining in the array, then the target value is smaller than correct value. If there are no more elemnets
    //in the array, and m splits have not been made yet (or exactly m splits have been made), then the target value is
    //too large.
    public static int splitArray(int[] nums, int m) {
        int max=-1,sum=0;
        for(int num:nums){
            max=Math.max(max, num);
            sum+=num;
        }
        if(m==1) return sum;
        if(m==nums.length) return max;
        long low=max,high=sum;
        while(low<=high){
            long mid=(low+high)/2;
            if(splitLeavesElements(nums,mid,m))
                low=mid+1;
            else
                high=mid-1;
        }
        return (int)low;
    }

    private static boolean splitLeavesElements(int[] nums, long target, int m) {
        int total=0,count=1;
        for(int num:nums){
            total+=num;
            if(total>target){
                total=num;
                count++;
                if(count>m)
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(splitArray(new int[]{7,2,5,10,8},2));
    }
}
