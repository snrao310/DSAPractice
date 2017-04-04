import java.util.HashMap;

/**
 * Created by S N Rao on 4/4/2017.
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 *
 */
public class ContiguousArrayLeetCode {

    public static int findMaxLength(int[] nums) {
        int track=0, res=Integer.MIN_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) track++;
            else track--;
            if(map.containsKey(track))
                res=Math.max(res,i-map.get(track));
            else
                map.put(track,i);
        }
        return (res==Integer.MIN_VALUE)?0:res;
    }

    public static void main(String args[]){
        System.out.println(findMaxLength(new int[]{1,1,1,1,0,0,0,0,0,1,0,1,1,1,1,0})); //14
        System.out.println(findMaxLength(new int[]{0,1})); //2
    }
}
