import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/9/16.
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourSumLeetCode {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-1;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int low=j+1;
                int high=nums.length-1;
                while (low<high){
                        if(nums[low]+nums[high] == target-(nums[i]+nums[j])){
                            result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                            while(low<high&&nums[low]==nums[low+1])low++;
                            while(low<high&&nums[high]==nums[high-1])high--;
                            low++;
                            high--;
                        }
                        else if(nums[i]+nums[j]+nums[low]+nums[high]>target) high--;
                        else low++;
                    }
            }
        }
        return result;
    }

    public static void main(String args[]){
        int[] arr={-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> k=fourSum(arr, 0);
        for(List<Integer> l:k){
            for(Integer m:l)
                System.out.print(m+" ");
            System.out.println();
        }

    }
}
