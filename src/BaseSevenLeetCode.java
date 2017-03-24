/**
 * Created by S N Rao on 3/23/2017.
 *
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 *
 * Example 2:
 * Input: -7
 * Output: "-10"
 *
 * Note: The input will be in range of [-1e7, 1e7].
 *
 */
public class BaseSevenLeetCode {

    public static String convertToBase7(int num) {
        StringBuilder res=new StringBuilder();
        if(num==0) return "0";
        boolean negative=false;
        if(num<0){
            num*=-1;
            negative=true;
        }
        while(num>0){
            int rem=num%7;
            num/=7;
            res.append(rem);
        }
        if(negative) res.append('-');
        return res.reverse().toString();
    }

    public static void main(String args[]){
        System.out.println(convertToBase7(-100));
        System.out.println(convertToBase7(100));
    }
}
