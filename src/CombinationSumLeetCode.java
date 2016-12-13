import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/12/16.
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the
 * candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * eg: array is [1] and target is 6.
 * [[1,1,1,1,1,1]] is solution.
 *
 *
 */
public class CombinationSumLeetCode {


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backTrackFunction(result, new ArrayList<>(), candidates,target,0);
        return result;
    }

    public static void backTrackFunction(List<List<Integer>> list, List<Integer> templist,
                                         int[] nums, int remain, int start){
        if(remain==0){
            list.add(new ArrayList<Integer>(templist));
            return;
        }
        if(remain<0)
            return;

        for(int i=start;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;  //no duplicates allowed. this is why we sorted it.
            templist.add(nums[i]);
            backTrackFunction(list,templist,nums,remain-nums[i],i); //no i+1 coz repetition of element allowed.
            templist.remove(templist.size()-1);
        }
    }


    public static void main(String args[]){
        int[] arr={2,3,2};
        List<List<Integer>> l=combinationSum(arr,7);

        for(List<Integer> k: l){
            for(int p:k) {
                System.out.print(p + " ");
            }
            System.out.println();
        }



    }


}
