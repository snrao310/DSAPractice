/**
 * Created by S N Rao on 4/7/2017.
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 */
public class PowerOfThreeLeetCode {

    public static boolean isPowerOfThree(int n) {
        //1162261467 is the largest power of 3 less than Integer.MAX_VALUE. It is 3^19.
        if(n>0 && 1162261467%n==0) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(36));
    }
}
