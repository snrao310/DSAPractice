import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by S N Rao on 3/30/2017.
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Follow up:
 * 1. What if the given array is already sorted? How would you optimize your algorithm?
 * 2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * 3. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into
 * the memory at once?
 *
 */
public class IntersectionOfTwoArraysIILeetCode {

    //Answers to followup questions
    //1. Use one pointer in each array. No extra storage.
    //2. If nums1 is too huge and nums2 is very small, its a huge overhead to use hashmap to store all elements in nums1
    //   first. So use the sorting method.
    //3. Sort the nums1 array. Do birany search of each element of num2 in num1 to find intersection. Store it in hashmap
    //   to maintain count of intersected elements.
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i:nums1) freq.put(i,freq.getOrDefault(i,0)+1);
        for(int i:nums2){
            int f=freq.getOrDefault(i,0);
            if(f>0)
                res.add(i);
            freq.put(i,f-1);
        }
        int[] resArray=new int[res.size()];
        for(int i=0;i<res.size();i++) resArray[i]=res.get(i);
        return resArray;
    }

    public static void main(String args[]){
        System.out.print(Arrays.toString(intersect(new int[]{1,2,3,4,5,6,7,7,4,4},new int[]{4,3,7,4,7,9})));
    }
}
