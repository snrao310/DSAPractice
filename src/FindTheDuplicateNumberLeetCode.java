/**
 * Created by S N Rao on 2/1/2017.
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least
 * one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 */
public class FindTheDuplicateNumberLeetCode {
    //One option is sort and check. That's O(nlogn). This one is a genius O(n) method.
    //Same as finding cycle in linked list, and finding where it starts.
    public static int findDuplicate(int[] nums) {
        int fast=nums[nums[0]],slow=nums[0];
        while(fast!=slow){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while(fast!=slow){
            fast=nums[fast];
            slow=nums[slow];
        }
        return slow;
    }

    public static void main(String args[]){
        System.out.println(findDuplicate(new int[]{1,2,3,4,5,4,6,7}));
    }
}
