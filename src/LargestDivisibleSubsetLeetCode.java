import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/27/16.
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements
 * in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 */
public class LargestDivisibleSubsetLeetCode {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums.length==0)
            return result;
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] previous=new int[nums.length];
        int globalMax=0,maxIndex=-1;
        for(int i=0;i<nums.length;i++){
            int max=0,prev=-1;
            for(int j=0;j<i;j++){
                if(dp[j]>max && nums[i]%nums[j]==0) {
                    max = dp[j];
                    prev=j;
                }
            }
            dp[i]=max+1;
            previous[i]=prev;
            if(dp[i]>globalMax) {
                globalMax = dp[i];
                maxIndex=i;
            }
        }

        int prev=maxIndex;
        while(prev!=-1){
            result.add(0,nums[prev]);
            prev=previous[prev];
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(largestDivisibleSubset(new int[]{15,12,2,3,5,6,8,1}));
    }
}
