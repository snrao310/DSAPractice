import java.util.HashMap;

/**
 * Created by snrao on 12/12/16.
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible
 * combinations that add up to a positive integer target.
 */
public class CombinationSumIVLeetCode {
    public static int combinationSum4(int[] nums, int target) {
        HashMap<Integer,Integer> combinations=new HashMap();
        combinations.put(0,1);

        return combFinder(nums,combinations,target);
    }

    //Dynamic programming memoization. Chose to do top-down (recursive) instead of more generic bottom up.
    // Filling only what's required (instead of filling all values till target as we do in bottom up)
    public static int combFinder(int[] nums, HashMap<Integer,Integer> combinations, int target){
        if(combinations.containsKey(target))
            return combinations.get(target);

        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target)
                sum+=combFinder(nums, combinations, target-nums[i]);
        }
        combinations.put(target,sum);
        return sum;
    }


    public static void main(String args[]){
        int[] k={1,2,3};
        System.out.println(combinationSum4(k,4));
    }
}
