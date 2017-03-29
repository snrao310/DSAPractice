import java.util.HashSet;

/**
 * Created by S N Rao on 3/28/2017.
 *
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 *
 */
public class ContainsDuplicateLeetCode {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(containsDuplicate(new int[]{1,3,4,5,6,7}));
        System.out.println(containsDuplicate(new int[]{1,3,4,5,6,1}));
    }
}
