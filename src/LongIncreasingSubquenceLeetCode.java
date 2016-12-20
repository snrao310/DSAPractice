/**
 * Created by snrao on 12/19/16.
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 */
public class LongIncreasingSubquenceLeetCode {

    //Dynamic programmin O(n^2) solution
    public static int lengthOfLIS_DP(int[] nums) {
        int dp[]=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]>=max)
                    max=dp[j]+1;
            }
            dp[i]=max;
        }

        int fullMax=0;
        for(int i=0;i<dp.length;i++)
            if(dp[i]>fullMax)
                fullMax=dp[i];

        return fullMax;
    }

    //Using binary search modification with complexity O(nlogn)
    public static int lengthOfLIS_BinSearch(int[] nums) {
        int[] tails=new int[nums.length]; //tails[i] smallest last element among all subsequences of length i.
                                          //size of this array will represent the length of longest subsequence.
                                          //not intuitive. check with example {4,5,6,3}.
        int size=0;
        for(int i=0;i<nums.length;i++){
            int low=0,high=size-1;
            while(low<=high) {
                int mid = (low + high) / 2;
                if(tails[mid]>nums[i])
                    high=mid-1;
                else if(tails[mid]<nums[i])
                    low=mid+1;
                else{
                    low=mid;
                    break;
                }
            }
            tails[low]=nums[i];
            if(low==size)
                size++;
        }
        return size;
    }


    public static void main(String args[]){
        System.out.print(lengthOfLIS_BinSearch(new int[]{2,2}));
    }
}
