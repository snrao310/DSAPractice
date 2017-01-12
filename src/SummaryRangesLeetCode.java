import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 1/11/2017.
 *
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class SummaryRangesLeetCode {

    //The trick is stack method of stock span problem can be used to find first number greater than 2 (in 1 3 2) on the left.
    // This is 3. Now check if min value to the left of 3, is less than 2.
    // Tried to find 3 from 1 and then find number between 1 and 2 on the right of 3, but it doesn't work coz of stockspan
    // works for only one check, number on right/left greater than or less than this, can't find number on the right/left which is
    // in between two numbers

    public static List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        if(nums.length==0) return result;
        if(nums.length==1){
            result.add(Integer.toString(nums[0]));
            return result;
        }

        String currString=Integer.toString(nums[0]);
        int end=nums[0],start=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                end=nums[i];
                if(i==nums.length-1){
                    currString+="->"+Integer.toString(end);
                    result.add(currString);
                }
            }
            else{
                if(end!=start) currString+="->"+Integer.toString(end);
                result.add(currString);
                currString=Integer.toString(nums[i]);
                start=nums[i];end=nums[i];
                if(i==nums.length-1)
                    result.add(currString);
            }
        }
        return result;
    }

    public static void main(String args[]){
        List<String> list=summaryRanges(new int[]{0,5,9});
        for(String s:list)
            System.out.print(s+" ");
    }
}
