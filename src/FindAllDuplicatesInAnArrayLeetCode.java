import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 2/6/2017.
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 */
public class FindAllDuplicatesInAnArrayLeetCode {

    //Awesome Method!!!! O(n) time. No extra space. More straightforward solutions are Hashmap (drawback: O(n) extra space)
    //and sorting (drawback: O(nlogn) time). This is best.
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i: nums){
            int k=Math.abs(i)-1;
            nums[k]=-nums[k];
            if(nums[k]>0)
                result.add(k+1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list=findDuplicates(new int[]{1,3,6,4,6,1,3,7});
        for(int i: list)
            System.out.print(i+" ");
    }


}