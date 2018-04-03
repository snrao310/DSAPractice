package Done;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by S N Rao on 2/7/2017.
 *
 * Given a circular array (the next element of the last element is the first element of the array), print the Next
 * Greater Number for every element. The Next Greater Number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.
 *
 * Note: The length of given array won't exceed 10000.
 *
 */
public class NextGreaterElementIILeetCode {

    //Stack solution O(n). Slight modification for circular array is that a second pass is made.
    public static int[] nextGreaterElements(int[] nums) {
        if(nums.length==0) return nums;
        int[] result=new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<nums.length;i++){
            while(!stack.isEmpty() && nums[i]>nums[stack.peek()])
                result[stack.pop()]=nums[i];
            stack.push(i);
        }

        for(int i=0;!stack.isEmpty() && i<stack.peek();i++){
            while(nums[i]>nums[stack.peek()])
                result[stack.pop()]=nums[i];
        }

        while(!stack.isEmpty())
            result[stack.pop()]=-1;

        return result;
    }

    public static void main(String args[]){
        int[] arr=nextGreaterElements(new int[]{-1,-2,-1,2,2,1,1});
        for(int i: arr)
            System.out.print(i+" ");
    }

}
