import java.util.HashMap;

/**
 * Created by S N Rao on 4/4/2017.
 *
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous
 * subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 *
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 *
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 *
 * Note:
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 *
 */
public class ContinuousSubarraySumLeetCode {

    //This is an awesome method. O(n^2) method is naive. O(nk) is possible if we check previous k non-zero elements
    //elements for each element. But the method here maintains remainders in a HashMap with the value having first index
    //where the remainder occurred. If the remainder occurs again, it means there has been a multiple of k added since
    //the first occurrence. So all elements after that index sums up to multiple of k. Just check if it contains more
    //than two elements and return true if it does. This gives O(n) complexity. Space is O(k) for HashMap.
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int runningSum=0;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            if(k!=0) runningSum%=k;
            if(map.containsKey(runningSum)){
                int j=map.get(runningSum);
                if(i-j > 1) return true;
            }
            else
                map.put(runningSum,i);
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(checkSubarraySum(new int[]{23,2,6,4,7},6)); //true
        System.out.println(checkSubarraySum(new int[]{23,2,7,},6)); //false
    }
}
