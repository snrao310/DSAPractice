/**
 * Created by S N Rao on 12/14/2016.
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 */
public class SingleNumberLeetCode {

    public static int singleNumber(int[] nums) {

        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;

    }

    public static void main(String args[]){
        int input1[]={2,3,2,4,3,6,7,7,6};

        int result1=singleNumber(input1);
        System.out.println(result1);
    }
}
