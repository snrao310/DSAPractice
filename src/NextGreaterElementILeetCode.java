import java.util.HashMap;
import java.util.Stack;

/**
 * Created by S N Rao on 2/7/2017.
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all
 * the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not
 * exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *  For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *  For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 *
 * Note:
 *  All elements in nums1 and nums2 are unique.
 *  The length of both nums1 and nums2 would not exceed 1000.
 *
 */
public class NextGreaterElementILeetCode {

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        if(findNums.length==0) return findNums;
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<nums.length;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()])
                map.put(nums[stack.pop()], nums[i]);
            stack.push(i);
        }

        while(!stack.isEmpty())
            map.put(nums[stack.pop()], -1);

        int[] result=new int[findNums.length];
        for(int i=0;i<findNums.length;i++)
            result[i]=map.get(findNums[i]);
        return result;
    }

    public static void main(String args[]){
        int[] res=nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
        for(int i:res)
            System.out.print(i+" ");
    }

}
