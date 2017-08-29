/**
 * Created by S N Rao on 8/29/2017.
 *
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 *
 */
public class ReverseIntegerLeetCode2 {

    public static int reverse(int x) {
        long result=0;
        int sign=(x<0)?-1:1;
        x=Math.abs(x);
        while(x>0){
            result*=10;
            result+=x%10;
            x/=10;
            if(result>Integer.MAX_VALUE) return 0;
        }
        result*=sign;
        if(result>Integer.MAX_VALUE) return 0;
        if(result<Integer.MIN_VALUE) return 0;
        return (int) result;
    }

    public static void main(String args[]){
        System.out.print(reverse(-123));
    }
}
