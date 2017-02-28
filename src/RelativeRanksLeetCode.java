import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by S N Rao on 2/27/2017.
 *
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be
 * awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and
 * "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 *
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 *
 */
public class RelativeRanksLeetCode {

    public static String[] findRelativeRanks(int[] nums) {
        if(nums.length==0) return null;
        int[] copy= Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<copy.length;i++)
            map.put(copy[i],copy.length-i);

        String[] res=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            int place=map.get(nums[i]);
            String insert=Integer.toString(place);
            if(place==1)
                insert="Gold Medal";
            else if(place==2)
                insert="Silver Medal";
            else if(place==3)
                insert="Bronze Medal";
            res[i]=insert;
        }
        return res;
    }

    public static void main(String args[]){
        String[] res=findRelativeRanks(new int[]{5,3,4,1,2});
        for(String s:res)
            System.out.print(s+" ");
    }
}
