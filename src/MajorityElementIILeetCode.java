import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 1/11/2017.
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run
 * in linear time and in O(1) space.
 *
 */
public class MajorityElementIILeetCode {

    //Majority Voting algorithm called Boyer-Moore, modified for n/3 majority. Simple to understand for n/2 majority. n/3
    // is slighty tricky. Basically two slots, since maximum of two n/3 majorities can exist. count is decresed only when
    // current element is neither of the candidtates.
    public List<Integer> majorityElement(int[] nums) {
        int candidate1=0,candidate2=1,count1=0,count2=0;
        int len=nums.length;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<len;i++){
            if(nums[i]==candidate1)
                count1++;
            else if(nums[i]==candidate2)
                count2++;
            else if(count1==0){
                count1++;
                candidate1=nums[i];
            }
            else if(count2==0){
                count2++;
                candidate2=nums[i];
            }
            else{
                count1--;count2--;
            }
        }

        count1=count2=0;
        for(int i=0;i<len;i++){
            if(nums[i]==candidate1) count1++;
            if(nums[i]==candidate2) count2++;
        }
        if(count1>len/3) result.add(candidate1);
        if(count2>len/3) result.add(candidate2);
        return result;
    }

    public static void main(String args[]){

    }
}
