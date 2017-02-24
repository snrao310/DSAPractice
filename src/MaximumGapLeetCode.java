import java.util.Arrays;

/**
 * Created by S N Rao on 2/24/2017.
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 *
 */
public class MaximumGapLeetCode {

    //Using radix sort. Time complexity O(10n)=O(n) coz max digits in an integer is 10 (2147483647).Space complexity O(n).
    //The input for this question contains only positive numbers. If the input had negative numbers also, then the radix sort
    //method used here needs to be modified. The sign should be treated as a separate digit (most significant digit ie leftmost)
    //and and sorting should be done based on it. This will store the negative numbers in reverse order. So a last step should
    //reverse order of negative numbers.
    public static int maximumGap(int[] nums) {
        int max=Integer.MIN_VALUE, len=nums.length, exp=1;
        if(len<=1) return 0;

        for(int i: nums)
            max=Math.max(max, i);

        //Radix sorting
        while(max/exp>0){
            int[] digitValue=new int[10];
            for(int i=0;i<len;i++)
                digitValue[(nums[i]/exp)%10]++;

            for(int i=1;i<10;i++)
                digitValue[i]+=digitValue[i-1];

            int dup[]=new int[len];
            for(int i=len-1;i>=0;i--){
                int ind=digitValue[(nums[i]/exp)%10]--;
                dup[ind-1]=nums[i];
            }

            for(int i=0;i<len;i++)
                nums[i]=dup[i];

            exp*=10;
        }

        //Finding max difference in sorted array
        int maxGap=Integer.MIN_VALUE;
        for(int i=1;i<len;i++)
            maxGap=Math.max(maxGap, nums[i]-nums[i-1]);

        return maxGap;
    }

    public static void main(String args[]){
        System.out.print(maximumGap(new int[]{5,3,15,1,20,18}));
    }
}
