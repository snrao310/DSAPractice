import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/13/16.
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 */
public class PermutationsIILeetCode {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];

        backTrackFunction(result,new ArrayList<>(), nums, used);

        return result;
    }

    public static void backTrackFunction(List<List<Integer>> list, List<Integer> tempList, int[] nums,
                                         boolean[] used){
        if(tempList.size()==nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i] || (i>0 && nums[i]==nums[i-1] && !used[i-1])) continue;
            used[i]=true;
            tempList.add(nums[i]);
            backTrackFunction(list,tempList,nums,used);
            used[i]=false;
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
        int[] arr={3,3,3,0};
        List<List<Integer>> lists=permuteUnique(arr);
        for(List<Integer> l:lists) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
