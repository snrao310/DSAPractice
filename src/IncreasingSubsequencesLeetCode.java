import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by S N Rao on 1/31/2017.
 *
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
 * and the length of an increasing subsequence should be at least 2 .
 *
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of
 * increasing sequence.
 *
 */
public class IncreasingSubsequencesLeetCode {

    public static List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> result=new HashSet<>();
        backTrackFunction(nums,result,new ArrayList<>(),0);
        return new ArrayList<>(result);
    }

    public static void backTrackFunction(int[] nums,HashSet<List<Integer>> set,List<Integer> tempList,int start){
        if(start>=nums.length)return;

        for(int i=start;i<nums.length;i++){
            if(tempList.size()==0 || tempList.get(tempList.size()-1)<=nums[i]) {
                tempList.add(nums[i]);
                if (tempList.size() > 1)
                    set.add(new ArrayList<>(tempList));
                backTrackFunction(nums, set, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String args[]){
        List<List<Integer>> list=findSubsequences(new int[]{4, 6, 7, 7});
        for(List<Integer> l: list){
            for(int i: l)
                System.out.print(i+" ");
            System.out.println();
        }
    }


}
