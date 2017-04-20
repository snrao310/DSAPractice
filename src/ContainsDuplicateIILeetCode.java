import java.util.HashMap;

/**
 * Created by S N Rao on 4/20/2017.
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 */
public class ContainsDuplicateIILeetCode {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0) return false;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(i>k) map.put(nums[i-k-1],map.get(nums[i-k-1])-1);
            if(map.containsKey(nums[i]) && map.get(nums[i])!=0) return true;
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,1,2},3)); //false
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,1,2},4)); //true
    }
}
