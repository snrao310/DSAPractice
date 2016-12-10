import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Created by snrao on 12/9/16.
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosestLeetCode {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum=nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int low=i+1;
            int high=nums.length-1;
            while(low<high){
                if(nums[i]+nums[low]+nums[high]==target){
                    return target;
                }
                else if(nums[i]+nums[low]+nums[high]<target) {
                    int kk=abs(nums[i]+nums[low]+nums[high]-target);
                    int bb=abs(closestSum-target);
                    if(abs(nums[i]+nums[low]+nums[high]-target)<abs(closestSum-target))
                        closestSum=nums[i]+nums[low]+nums[high];
                    low++;
                }
                else {
                    if(abs(nums[i]+nums[low]+nums[high]-target)<abs(closestSum-target))
                        closestSum=nums[i]+nums[low]+nums[high];
                    high--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String args[]) {
        int[] arr = {-3,-2,-5,3,-4};
        int k = threeSumClosest(arr,-1);
        System.out.println(k);
    }
}
