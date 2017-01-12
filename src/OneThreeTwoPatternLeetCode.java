import java.util.Arrays;
import java.util.Stack;

/**
 * Created by S N Rao on 1/11/2017.
 *
 *
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k
 * and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern
 * in the list.
 * Note: n will be less than 15,000.
 *
 */
public class OneThreeTwoPatternLeetCode {

    public static boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        int[] min=new int[nums.length];
        Arrays.fill(min,-1);int minv=0;min[0]=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[minv])minv=i;
            min[i]=minv;
        }
        Stack<Integer> prevGreater=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!prevGreater.empty() && nums[prevGreater.peek()]<nums[i]){
                if(nums[min[i]]<nums[prevGreater.pop()] && min[i]!=i) return true;
            }
            prevGreater.push(i);
        }

        return false;
    }

    public static void main(String args[]){
        System.out.print(find132pattern(new int[]{1,4,3}));
    }
}
