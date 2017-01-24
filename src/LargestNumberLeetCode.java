import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by S N Rao on 1/24/2017.
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 */
public class LargestNumberLeetCode {

    public static String largestNumber(int[] nums) {
        String[] numsString=new String[nums.length];
        boolean different=false;
        int prev=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=prev) different=true;
            numsString[i]=Integer.toString(nums[i]);
            prev=nums[i];
        }
        if(!different && prev==0) return "0";
        if(different) {
            Arrays.sort(numsString, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String s1, s2;
                    int m = o1.length(), n = o2.length();
                    int i, j;
                    for (i = 0, j = 0; i < m + n; i++, j++) {
                        s1 = (i >= m) ? o2 : o1;
                        s2 = (j >= n) ? o1 : o2;
                        if (s1.charAt(i % m) > s2.charAt(j % n))
                            return -1;
                        else if (s1.charAt(i % m) < s2.charAt(j % n))
                            return 1;
                    }
                    return 0;
                }
            });
        }

        String result="";
        for(int i=0;i<numsString.length;i++)
            result+=numsString[i];
        return result;
    }

    public static void main(String args[]){
        System.out.print(largestNumber(new int[]{0,0,1}));
    }
}
