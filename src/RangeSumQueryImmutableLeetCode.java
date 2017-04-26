/**
 * Created by S N Rao on 4/25/2017.
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 */
public class RangeSumQueryImmutableLeetCode {

    public static class NumArray {

        int[] sumTill;

        public NumArray(int[] nums) {
            sumTill=new int[nums.length+1];
            for(int i=0;i<nums.length;i++)
                sumTill[i+1]=sumTill[i]+nums[i];
        }

        public int sumRange(int i, int j) {
            return sumTill[j+1]-sumTill[i];
        }
    }

    public static void main(String args[]){
        /**
         * Your NumArray object will be instantiated and called as such:
         * NumArray obj = new NumArray(nums);
         * int param_1 = obj.sumRange(i,j);
         */
        NumArray obj=new NumArray(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println(obj.sumRange(0,9)); //55
        System.out.println(obj.sumRange(0,5)); //21
        System.out.println(obj.sumRange(6,9)); //34
    }
}
