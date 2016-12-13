import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/12/16.
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * No duplicates
 */
public class CombinationSumIILeetCode {


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrackFunction(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }


    public static void backtrackFunction(List<List<Integer>> list, List<Integer> templist, int[] nums,
                                         int remain, int start){
        if(remain==0){
            list.add(new ArrayList<>(templist));
            return;
        }
        if(remain<0)
            return;

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue; //To avoid duplicates. This is why we sorted it. Note that its i>start not i>0.
            templist.add(nums[i]);
            backtrackFunction(list, templist, nums, remain - nums[i], i+1); //note that no repetitions allowed so its i+1, not i
            templist.remove(templist.size()-1);
        }
    }

    public static void main(String args[]){
        int[] arr={10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> l=combinationSum2(arr,8);

        for(List<Integer> k: l){
            for(int p:k) {
                System.out.print(p + " ");
            }
            System.out.println();
        }

    }
}
