/**
 * Created by S N Rao on 12/15/2016.
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 */
public class TwoSumIILeetCode {

    public static int[] twoSumSorted(int[] numbers, int target) {
        int result[]=new int[2];
        int pointer=0;
        for(int i=numbers.length-1;i>=0;i--){
            while(numbers[i]+numbers[pointer]<target){
                pointer++;
            }
            if(numbers[i]+numbers[pointer]==target){
                result[0]=pointer+1;
                result[1]=i+1;
                break;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int numbers[]={2, 7, 11, 15};
        twoSumSorted(numbers, 9); //No extra space
    }
}
