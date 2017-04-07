/**
 * Created by S N Rao on 4/7/2017.
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 */
public class PowerOfTwoLeetCode {

    public static boolean isPowerOfTwo(int n) {
        //For every power of two n&(n-1) will be 0. Converse is also true. eg: 100 & 011 = 0
        if(n>0 && (n&(n-1))==0) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(10));
    }
}
