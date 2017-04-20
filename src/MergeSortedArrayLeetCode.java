import java.util.Arrays;

/**
 * Created by S N Rao on 4/20/2017.
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from
 * nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */
public class MergeSortedArrayLeetCode {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1, p2=n-1, p=m+n-1;
        while(p1!=-1 && p2!=-1){
            if(nums1[p1]>nums2[p2]) nums1[p--]=nums1[p1--];
            else nums1[p--]=nums2[p2--];
            if(p1==-1) break;
        }
        while(p2>=0)
            nums1[p--]=nums2[p2--];
    }

    public static void main(String args[]){
        int[] nums1={1,4,0};
        int[] nums2={3};
        merge(nums1,2,nums2,1);
        System.out.print(Arrays.toString(nums1));
    }
}
