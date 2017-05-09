import java.util.HashMap;

/**
 * Created by S N Rao on 5/9/2017.
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum
 * equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 */
public class SubarraySumEqualsKLeetCode {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0,res=0;
        for(int i:nums) {
            sum+=i; map.put(sum,map.getOrDefault(sum,0)+1);
        }
        res+=map.getOrDefault(k,0);
        sum=0;
        for(int i=0;i<nums.length-1;i++){
            sum+=nums[i];
            map.put(sum,map.get(sum)-1);
            res+=map.getOrDefault(sum+k,0);
        }
        return res;

    }

    public static void main(String args[]){
        System.out.print(subarraySum(new int[]{1,1,1},2));
    }
}
