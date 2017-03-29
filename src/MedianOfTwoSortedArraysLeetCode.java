import java.util.Arrays;

/**
 * Created by S N Rao on 3/28/2017.
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianOfTwoSortedArraysLeetCode {

    //Main problem is that the arrays have different sizes. Else we can solve it with normal median of medians approach
    //dividing array by half everytime eliminating one half of first array and other half of second array in each
    //recursive call.
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length;
        if(len1==0 && len2==0) return -1;

        //Keeping first input array always smaller than second input array
        if(len1<len2)
            return medians(nums1,0,nums1.length-1,nums2,0,nums2.length-1);
        else
            return medians(nums2,0,nums2.length-1,nums1,0,nums1.length-1);
    }

    private static double medianOfNumbers(int a, int b){
        return (a+b)/2.0;
    }

    private static double medianOfNumbers(int a, int b, int c){
        int[] arr={a,b,c};
        Arrays.sort(arr);
        return arr[1];
    }

    private static double medianOfNumbers(int a, int b,int c, int d){
        int[] arr={a,b,c,d};
        Arrays.sort(arr);
        return medianOfNumbers(arr[1],arr[2]);
    }


    private static double medians(int[] nums1,int start1, int end1, int[] nums2, int start2, int end2){
        int len1=end1-start1+1, len2=end2-start2+1;
        int mid1=start1+len1/2, mid2=start2+len2/2;

        //////Base Cases
        if(len1==0){
            if(len2%2==0)
                return medianOfNumbers(nums2[mid2],nums2[mid2-1]);
            else
                return nums2[mid2];
        }

        if(len1==1){
            if(len2==1)
                return medianOfNumbers(nums1[start1],nums2[start2]);
            if(len2%2==1)
                return medianOfNumbers(nums2[mid2],(int)medianOfNumbers(nums2[mid2-1],nums2[mid2+1],nums1[start1]));
            else
                return medianOfNumbers(nums2[mid2],nums2[mid2-1],nums1[start1]);
        }

        if(len1==2){
            if(len2==2)
                return medianOfNumbers(nums1[start1],nums1[end1],nums2[start2],nums2[end2]);
            if(len2%2==1)
                return medianOfNumbers(nums2[mid2],Math.max(nums1[start1],nums2[mid2-1]),Math.min(nums1[end1],nums2[mid2+1]));
            else
                return medianOfNumbers(nums2[mid2],nums2[mid2-1],Math.max(nums1[start1],nums2[mid2-2]),Math.min(nums1[end1],nums2[mid2+1]));
        }
        ////End of Base Cases

        ////Recursion part
        //If array sizes were equal, we'd do only this part without worrying about how much to remove (always removing
        //half of both arrays since they have same length).
        int med1=nums1[mid1];
        int med2=nums2[mid2];
        int elementsOnRight=end1-mid1; //We need to reduce by same amount in both arrays to maintain the median at center.
                                       //So we must always remove less than half of the smaller array from each array.
                                       //We chose elements on right of mid1 coz mid1 is len/2 (not (len-1)/2) ie. its the 2nd
                                       //element of the two middle elements for even length array. So there are always less
                                       //elements on the right as compared to left.
        if(med1>med2)
            return medians(nums1,start1,mid1,nums2,start2+elementsOnRight,end2);
        else
            return medians(nums1,start1+elementsOnRight,end1,nums2,start2,end2-elementsOnRight);
        ////End of Recursion part
    }

    public static void main(String args[]){
        System.out.print(findMedianSortedArrays(new int[]{2,2,2,7,8,9},new int[]{2,6,7,9}));
    }
}



/*
 Before we proceed to complete solution, let us first talk about all base cases.

Let the two arrays be A[N] and B[M]. In the following explanation, it is assumed that N is smaller than or equal to M.

Base cases:
The smaller array has only one element
Case 0: N = 0, M = 2
Case 1: N = 1, M = 1.
Case 2: N = 1, M is odd
Case 3: N = 1, M is even
The smaller array has only two elements
Case 4: N = 2, M = 2
Case 5: N = 2, M is odd
Case 6: N = 2, M is even

Case 0: There are no elements in first array, return median of second array. If second array is also empty, return -1.

Case 1: There is only one element in both arrays, so output the average of A[0] and B[0].

Case 2: N = 1, M is odd
Let B[5] = {5, 10, 12, 15, 20}
First find the middle element of B[], which is 12 for above array. There are following 4 sub-cases.
…2.1 If A[0] is smaller than 10, the median is average of 10 and 12.
…2.2 If A[0] lies between 10 and 12, the median is average of A[0] and 12.
…2.3 If A[0] lies between 12 and 15, the median is average of 12 and A[0].
…2.4 If A[0] is greater than 15, the median is average of 12 and 15.
In all the sub-cases, we find that 12 is fixed. So, we need to find the median of B[ M / 2 – 1 ], B[ M / 2 + 1], A[ 0 ]
and take its average with B[ M / 2 ].

Case 3: N = 1, M is even
Let B[4] = {5, 10, 12, 15}
First find the middle items in B[], which are 10 and 12 in above example. There are following 3 sub-cases.
…3.1 If A[0] is smaller than 10, the median is 10.
…3.2 If A[0] lies between 10 and 12, the median is A[0].
…3.3 If A[0] is greater than 12, the median is 12.
So, in this case, find the median of three elements B[ M / 2 – 1 ], B[ M / 2] and A[ 0 ].

Case 4: N = 2, M = 2
There are four elements in total. So we find the median of 4 elements.

Case 5: N = 2, M is odd
Let B[5] = {5, 10, 12, 15, 20}
The median is given by median of following three elements: B[M/2], max(A[0], B[M/2 – 1]), min(A[1], B[M/2 + 1]).

Case 6: N = 2, M is even
Let B[4] = {5, 10, 12, 15}
The median is given by median of following four elements: B[M/2], B[M/2 – 1], max(A[0], B[M/2 – 2]), min(A[1], B[M/2 + 1])

Remaining Cases:
Once we have handled the above base cases, following is the remaining process.
1) Find the middle item of A[] and middle item of B[].
…..1.1) If the middle item of A[] is greater than middle item of B[], ignore the last half of A[], let length of ignored
part is idx. Also, cut down B[] by idx from the start.
…..1.2) else, ignore the first half of A[], let length of ignored part is idx. Also, cut down B[] by idx from the last.
 */