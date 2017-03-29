/**
 * Created by S N Rao on 3/28/2017.
 */
public class MedianOfTwoSortedArraysOfSameLength {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            return medians(nums1,0,nums1.length-1,nums2,0,nums2.length-1);
    }

    private static double medians(int[] nums1,int start1, int end1, int[] nums2, int start2, int end2){
        int len=end1-start1+1, isEven=(len%2==0)?1:0;
        int mid1=start1+len/2, mid2=start2+len/2;

        //Base Case part
        if(len==2){
            int one=Math.max(nums1[start1],nums2[start2]);
            int two=Math.min(nums1[end1],nums2[end2]);
            return (one+two)/2.0;
        }
        int med1=nums1[mid1];
        int med2=nums2[mid2];
        if(med1==med2) return med1;

        //Recursion part
        if(med1>med2)
            return medians(nums1,start1,mid1,nums2,mid2-isEven,end2);
        else
            return medians(nums1,mid1-isEven,end1,nums2,start2,mid2);
    }

    public static void main(String args[]){
        System.out.print(findMedianSortedArrays(new int[]{1,3,5,6},new int[]{2,4,7,8}));
    }
}
