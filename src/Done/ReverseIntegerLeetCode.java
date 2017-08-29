package Done;

/**
 * Created by S N Rao on 4/17/2017.
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
public class ReverseIntegerLeetCode {

    public static int reverse(int x) {
        boolean neg=false;
        long res=0;
        if (x<0) neg=true;
        x=Math.abs(x);
        while(x>0){
            res*=10;
            res+=x%10;
            x/=10;
        }
        if(res>Integer.MAX_VALUE) return 0;
        return (neg)? (-1*(int)res):(int)res;
    }

    public static void main(String args[]){
        System.out.print(reverse(-345));
    }
}
