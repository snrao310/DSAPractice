import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 9/30/2016.
 */
public class TwoSum {

    public static void main(String args[]) {
        int numbers[]={2, 7, 11, 15};

        twoSum(numbers,9);
        twoSumSorted(numbers, 9);
    }



    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> lookup=new HashMap<Integer,Integer>();
        int result[]=new int[2];

        for(int i=0;i<nums.length;i++){
            if(lookup.containsKey(target-nums[i])){
                result[0]=lookup.get(target-nums[i]);
                result[1]=i;
                break;
            }
            lookup.put(nums[i],i);
        }

        return result;
    }



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
}
