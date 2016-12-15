import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 9/30/2016.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 */
public class TwoSumLeetCode {

    public static void main(String args[]) {
        int numbers[]={2, 7, 11, 15};
        twoSum(numbers,9);  //Hashtable
    }



    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> lookup=new HashMap<Integer,Integer>();
        int result[]=new int[2];

        for(int i=0;i<nums.length;i++){
            if(lookup.containsKey(target-nums[i])){
                result[0]=lookup.get(target-nums[i]);
                result[1]=i;
                break;
            }
            lookup.put(nums[i],i);
        }

        return result;
    }
}
