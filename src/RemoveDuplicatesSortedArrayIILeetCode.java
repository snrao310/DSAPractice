/**
 * Created by snrao on 12/22/16.
 *
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example, Given sorted array nums = [1,1,1,2,2,3], Your function should return length = 5, with the
 * first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *
 */
public class RemoveDuplicatesSortedArrayIILeetCode {

    //Two pointers
    public static int removeDuplicates(int[] nums) {
        int i=0,j=0,count=1,currCount=1;
        for(i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                nums[count++]=nums[i];
                j=i;
                currCount=1;
            }
            else{
                currCount++;
                if(currCount<=2) {
                    nums[count++] = nums[i];
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        int[] nums=new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
}
