import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/22/16.
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 *
 */
public class SubsetsIILeetCode {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        backTrackFunction(result,new ArrayList<>(),nums,0);
        return result;
    }

    public static void backTrackFunction(List<List<Integer>> list, List<Integer> tempList,int[] nums,int start){
        list.add(new ArrayList<>(tempList));

        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1])continue;
            tempList.add(nums[i]);
            backTrackFunction(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
        int[] nums = {1,2,2};
        List<List<Integer>> l=subsetsWithDup(nums);
        for (List<Integer> list:l){
            for (int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
