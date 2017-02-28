import java.util.Arrays;

/**
 * Created by S N Rao on 2/27/2017.
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 * non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
public class MoveZeroesLeetCode {

    public static void moveZeroes(int[] nums) {
        int pointer1=0, pointer2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[pointer1]; nums[pointer1]=nums[pointer2]; nums[pointer2]=temp;
                pointer1++;
            }
            pointer2++;
        }
    }

    public static void main(String args[]){
        int[] nums={0,1,2,0,0,3,5,0,6,7,0};
        moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }
}
