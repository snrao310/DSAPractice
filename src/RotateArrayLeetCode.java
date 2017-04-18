import java.util.Arrays;

/**
 * Created by S N Rao on 4/17/2017.
 *
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 */
public class RotateArrayLeetCode {

    //Chaitanya's trick with the triangle representing the strings.
    public static void rotate(int[] nums, int k) {
        int n=nums.length; k=k%n;
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }

    private static void reverse(int[] nums,int start,int end){
        int j=end-start+1;
        for(int i=0;i<j/2;i++){
            int temp=nums[start+i];
            nums[start+i]=nums[end-i];
            nums[end-i]=temp;
        }
    }

    public static void main(String args[]){
        int[] nums=new int[]{1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.print(Arrays.toString(nums));
    }
}
