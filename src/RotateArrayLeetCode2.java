import java.util.Arrays;

/**
 * Created by S N Rao on 8/29/2017.
 *
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 */
public class RotateArrayLeetCode2 {

    //Chaitanya's trick with the triangle representing the strings.
    public static void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    private static void reverse(int[] nums, int start,int end){
        int n=(end-start)+1;
        for(int i=0;i<n/2;i++){
            int temp=nums[i+start];
            nums[i+start]=nums[n-i-1+start];
            nums[n-i-1+start]=temp;
        }
    }

    public static void main(String args[]){
        int[] nums=new int[]{1};
        rotate(nums,0);
        System.out.print(Arrays.toString(nums));
    }
}

