/**
 * Created by snrao on 12/20/16.
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 */
public class SortColorsLeetCode {

    //Quicksort pivot partition method.
    public static void sortColors(int[] nums) {
        int redEnd=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[redEnd];
                nums[redEnd]=temp;
                redEnd++;
            }
        }
        int whiteEnd=redEnd;
        for(int i=redEnd;i<nums.length;i++){
            if(nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[whiteEnd];
                nums[whiteEnd]=temp;
                whiteEnd++;
            }
        }
    }

    public static void main(String args[]){
        int[] nums={0,1,1,1,2,0,1,2,2,0,0,2,1};
        sortColors(nums);
        for(int i:nums)
            System.out.print(i+" ");
    }
}
