import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/20/16.
 *
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 *
 */
public class SubsetsLeetCode {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backTrackFunction(result,new ArrayList<>(),nums,0);
        return result;
    }

    public static void backTrackFunction(List<List<Integer>> list,List<Integer> tempList,
                                         int[] nums, int start){
        list.add(new ArrayList<>(tempList));

        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            backTrackFunction(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
        List<List<Integer>> list=subsets(new int[]{1,2,3});
        for(List<Integer> l:list){
            for(int i:l)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
