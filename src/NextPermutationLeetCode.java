/**
 * Created by S N Rao on 1/10/2017.
 *
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 *
 */
public class NextPermutationLeetCode {

    public static void nextPermutation(int[] nums) {
        if(nums.length==0) return;;
        int lastMin=0, next=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]) {
                lastMin = i;
                next = i + 1;
            }
            else if(nums[i+1]<=nums[next] && nums[i+1]>nums[lastMin])
                next=i+1;
        }

        swap(nums, next, lastMin);
        if(lastMin==next)
            lastMin=-1;
        reverse(nums,lastMin+1);
    }

    private static void reverse(int[] nums, int ind){
        int mid=ind-1+(nums.length-ind)/2;
        for(int i=ind;i<=mid;i++){
            swap(nums,i,nums.length-i+ind-1);
        }
    }

    private static void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public static void main(String args[]){
        int nums[]={2,3,1,3,3};
        nextPermutation(nums);
        for(int i: nums){
            System.out.print(i+" ");
        }
    }
}
