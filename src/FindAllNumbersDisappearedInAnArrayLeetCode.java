import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 2/14/2017.
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 */
public class FindAllNumbersDisappearedInAnArrayLeetCode {

    //Very very similar to FindAllDuplicatesInAnArray
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int val=Math.abs(nums[i])-1;
            if(nums[val]>0)
                nums[val]=-nums[val];
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            if(nums[i]>0) result.add(i+1);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list=findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        for(int i:list)
            System.out.print(i+" ");
    }

}
