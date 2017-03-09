import java.util.Arrays;

/**
 * Created by S N Rao on 3/9/2017.
 *
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length
 * k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an
 * array of the k digits. You should try to optimize your time and space complexity.
 *
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]
 *
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 *
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 *
 */
public class CreateMaximumNumberLeetCode {

    // To create max number of length k from two arrays, you need to create max number of length i from array one and max
    // number of length k-i from array two, then combine them together. After trying all possible i, you will get the max
    // number created from two arrays.
    //
    // Suppose nums1 = [3, 4, 6, 5], nums2 = [9, 1, 2, 5, 8, 3], and k=5, and you try for all length combination. The one
    // that works is 2 for nums1 and 3 for nums2. The maximum number you can create from nums1 is [6, 5] with length 2.
    // For nums2, it's [9, 8, 3] with length 3. Merging the two sequence, we have [9, 8, 6, 5, 3],
    // which is the max number we can create from two arrays for k=5.

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans=new int[k];
        int n=nums1.length, m=nums2.length;
        for(int i=Math.max(0,k-m);i<=n && i<=k;i++){
            int[] candidate=merge(maxArray(nums1,i),maxArray(nums2,k-i));
            ans=greater(candidate,0,ans,0)?candidate:ans;
        }
        return ans;
    }

    //Merges the two maxArrays. Not just merge sort type. Need to do it lexicographically when digits from both arrays
    // are equal. For example try [7,8,4,6,3] and [5,4,2,4].
    private static int[] merge(int[] nums1, int[] nums2){
        int k=nums1.length+nums2.length;
        int[] ans=new int[k];
        int j=0, l=0;
        for(int i=0;i<k;i++)
            ans[i]=greater(nums1,j,nums2,l)?nums1[j++]:nums2[l++];
        return ans;
    }

    //Finds max array of given k. ie lexicographically largest array of size k in from the nums array.
    private static int[] maxArray(int[] nums, int k){
        int n=nums.length, j=0;
        int[] ans=new int[k];
        for(int i=0;i<n;i++){
            while(n-i+j>k && j>0 && nums[i]>ans[j-1]) j--;
            if(j<k) ans[j++]=nums[i];
        }
        return ans;
    }

    //Returns true if array num1 is lexicographically greater than array num2.
    private static boolean greater(int[] nums1, int i, int[] nums2, int j){
        while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){
            i++; j++;
        }
        if(j==nums2.length) return true;
        if(i!= nums1.length && nums1[i]>nums2[j]) return true;
        return false;
    }

    public static void main(String args[]){
        int[] a=maxNumber(new int[]{6,7},new int[]{6,0,4}, 5);
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
