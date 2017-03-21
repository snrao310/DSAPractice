import java.util.HashSet;

/**
 * Created by S N Rao on 3/21/2017.
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 */
public class IntersectionOfTwoArraysLeetCode {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>(), res=new HashSet<>();
        for(int i:nums1) set.add(i);
        for(int i:nums2){
            if(set.contains(i))
                res.add(i);
        }
        int[] resArray=new int[res.size()];
        int j=0;
        for(int i:res) resArray[j++]=i;
        return resArray;
    }

    public static void main(String args[]){
        int[] res=intersection(new int[]{1,2,3,4},new int[]{1,1,1,2});
        for(int i: res)
            System.out.print(i+" ");
    }
}
