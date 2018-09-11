import java.util.Arrays;

/**
 * Created by S N Rao on 2/2/2017.
 *
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 */
public class ShuffleAnArrayLeetCode {

    public static class Solution {

        int[] original;

        public Solution(int[] nums) {
            original = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return original;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int len=original.length;
            int[] shuffled=new int[len];
            for(int i=0;i<len;i++) shuffled[i]=original[i];
            for(int i=0;i<len;i++){
                int rand = i + (int)(Math.random()*(len-i));
                int temp = shuffled[i];
                shuffled[i]=shuffled[rand];
                shuffled[rand]=temp;
            }
            return shuffled;
        }
    }

    public static void main(String args[]){
        /**
         * Your Solution object will be instantiated and called as such:
         * Solution obj = new Solution(nums);
         * int[] param_1 = obj.reset();
         * int[] param_2 = obj.shuffle();
         */

        Solution obj=new Solution(new int[]{1,2,3});
        int[] a;
        a=obj.shuffle();
        for(int i: a) System.out.print(i+" ");
        System.out.println();
        a=obj.reset();
        for(int i: a) System.out.print(i+" ");
    }
}
