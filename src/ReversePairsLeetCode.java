import java.util.Arrays;

/**
 * Created by S N Rao on 3/29/2017.
 *
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 * Input: [1,3,2,3,1]
 * Output: 2
 *
 * Example2:
 * Input: [2,4,3,5,1]
 * Output: 3
 *
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 *
 */
public class ReversePairsLeetCode {

    static int inversions;
    public static int reversePairs(int[] nums) {
        if(nums.length==0) return 0;
        inversions=0;
        mergeSortFunction(nums);
        return inversions;
    }

    //Same as counting inversion problem
    private static void mergeSortFunction(int[] nums){
        int len=nums.length;
        if(len==1)
            return;

        //Divide
        int[] A= Arrays.copyOfRange(nums,0,len/2);
        int[] B=Arrays.copyOfRange(nums,len/2,len);
        mergeSortFunction(A);
        mergeSortFunction(B);

        //Merge step
        int j=0,k=0;
        for(int i=0;i<len;i++){
            if(A[j]<=B[k])
                nums[i]=A[j++];
            else
                nums[i]=B[k++];

            if(j==A.length){
                i++;
                while(k!=B.length)
                    nums[i++]=B[k++];
                break;
            }
            if(k==B.length){
                i++;
                while(j!=A.length)
                    nums[i++]=A[j++];
                break;
            }
        }
        //End of merge sort

        //Counting inversions separately. For the general inversion, can do it while merging itself. This is special
        //inversion with 2*element comparison.
        j=0;
        for(int i=0;i<B.length;i++){
            while(j<A.length && A[j]<=(long)B[i]*2)
                j++;
            if(j==A.length) break;
            inversions+=A.length-j;
        }
    }

    public static void main(String args[]){
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
        System.out.println(reversePairs(new int[]{2,4,3,5,1}));
        System.out.println(reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
}
