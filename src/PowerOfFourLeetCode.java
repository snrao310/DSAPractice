/**
 * Created by S N Rao on 4/7/2017.
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 */
public class PowerOfFourLeetCode {

    public static boolean isPowerOfFour(int num) {
        //The number must be a power of 2. So check num&(num-1)==0. If it passes this is of the form 10000...00.
        //Now we need to check if the 1 is in odd place. If yes, its a power of 4 (eg: 100, 10000, 1000000 etc.)
        //So we and with largest integer with all odd bits set and even bits unset.
        //That is 0101010101010101010101010101010 (31 bits only since last bit is sign bit). This number is 715827882.
        //So we check if num&715827882==0 and if yes return true. Or just convert to hex as 0x2aaaaaaa and check if
        //(num& 0x2aaaaaaa)==0 and if yes return true.

        // if(num>0 && (num&(num-1))==0 && (num&0x2aaaaaaa)==0) return true;
        if(num>0 && (num&(num-1))==0 && (num&715827882)==0) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(36));
    }
}
