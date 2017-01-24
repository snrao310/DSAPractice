import java.util.TreeSet;

/**
 * Created by S N Rao on 1/24/2017.
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 */
public class ContainsDuplicateIIILeetCode {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(i>k) set.remove(nums[i-k-1]);
            Integer floor=set.floor(nums[i]);
            Integer ceil=set.ceiling(nums[i]);
            if(floor!=null && (long)nums[i]-(long)floor<=t) return true;
            if(ceil!=null && (long)ceil-(long)nums[i]<=t) return true;
            set.add(nums[i]);
        }
        return false;


    }

    public static void main(String args[]){
        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647},1,2147483647));
    }



}
