import java.util.Arrays;

/**
 * Created by S N Rao on 2/23/2017.
 *
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 * Return 3.
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 *
 */
public class CountOfRangeSumLeetCode {

    //This is officially the most complicated problem encountered on leetcode till date (2/23/2017).
    //Although the premise is pretty simple (just counting inversion merge sort type logic), the intricacies of the
    //whole thing are immense. Very challenging and demanded a lot of concentration.

    //The logic is that first sum the array, and send the sum array to merge sort function. That function computes the
    //answer in two halves of the array and sorts it based on the sums as well in the process. The whole genius of the
    //algorithm lies in the count step before the merge step.

    //During the count and merge stage, we have already sorted the left half [start, mid) and right half [mid, end). We then iterate
    //through the left half with index i. For each i, we need to find two indices j and k in the right half where

    //j is the first index satisfy sums[j] - sums[i] >= lower.
    //k is the first index satisfy sums[k] - sums[i] > upper.

    //Then the number of sums in [lower, upper] is k-j. We increase the answer variable by this value.

    //Despite the nested loops (having to find j and k for each i), the time complexity of the "count & merge" stage is
    //still linear. Because the indices k, j, will only increase but not decrease, each of them will only traverse the
    //right half once at most. The total time complexity of this divide and conquer solution is then O(n log n).

    static int answer=0;
    public static int countRangeSum(int[] nums, int lower, int upper) {
        answer=0;
        long[] sums=new long[nums.length+1];
        for(int i=0;i<nums.length;i++)
            sums[i+1]=sums[i]+nums[i];
        mergeSortFunction(sums,lower,upper);
        return answer;
    }

    private static long[] mergeSortFunction(long[] sums,int lower,int upper){
        if(sums.length==1){
            return sums;
        }

        //divide step
        int len=sums.length;
        long[] A= Arrays.copyOfRange(sums,0,len/2);
        long[] B=Arrays.copyOfRange(sums,len/2,len);
        mergeSortFunction(A,lower,upper);
        mergeSortFunction(B,lower,upper);

        //Counting range sums
        int j=0,k=0;
        for(int i=0;i<A.length;i++){
            while(j<B.length && B[j]-A[i]<lower)
                j++;
            k=j;
            while(k<B.length && B[k]-A[i]<=upper)
                k++;
            if(j>=0 && k>=0)
                answer+=(k-j);
        }

        //Merge step
        j=0;k=0;
        for(int i=0;i<sums.length;){
            if(A[j]<=B[k])
                sums[i++]=A[j++];
            else
                sums[i++]=B[k++];
            if(j==A.length){
                while(k!=B.length)
                    sums[i++]=B[k++];
                break;
            }
            else if(k==B.length){
                while(j!=A.length)
                    sums[i++]=A[j++];
                break;
            }
        }
        return sums;
    }

    public static void main(String argsp[]){
        System.out.print(countRangeSum(new int[]{0,-2,3},-2,2));
    }
}
