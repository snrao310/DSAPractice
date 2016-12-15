/**
 * Created by S N Rao on 12/14/2016.
 *
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */
public class SingleNumberIILeetCode {

    public static int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<32;i++){
            int mask= 1<<i;
            int numOfOnes=0;
            for(int j=0;j<nums.length;j++){
                if((mask & nums[j])!=0)
                    numOfOnes++;
            }
            if(numOfOnes%3!=0)              //we check if number of elements in array having ith bit set is a multiple of 3.
                result |= mask;             // If not, then answer has this bit set. If yes, then answer doesn't have it set.
        }
        return result;
    }


    public static void main(String args[]) {
        int input1[] = {2, 3, 2, 4, 3, 6, 7, 7, 6, 2, 3, 6, 7};

        int result1 = singleNumber(input1);
        System.out.println(result1);
    }
}
