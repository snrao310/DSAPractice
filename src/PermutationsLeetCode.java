import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/13/16.
 *
 * Given a collection of distinct numbers, return all possible permutations.
 */

//similar to CombinationSum problems.
public class PermutationsLeetCode {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backTrackFunction(result, new ArrayList<>(), nums);
        return result;
    }

    public static void backTrackFunction(List<List<Integer>> list,List<Integer> tempList,
                                         int[] nums){
        if(tempList.size()==nums.length){
            list.add(new ArrayList<Integer>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]);
            backTrackFunction(list,tempList,nums);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
        int[] arr={1,2,3};
        List<List<Integer>> lists=permute(arr);
        for(List<Integer> l:lists) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
