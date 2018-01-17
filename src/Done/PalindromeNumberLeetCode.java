package Done;

/**
 * Created by S N Rao on 4/18/2017.
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 */
public class PalindromeNumberLeetCode {

    //reverse half of the number while dividing it by 10 during each iteration. Check if
    //reversed half same as unreversed. Don't need to worry about overflow for reversed
    //number since its only half the digits of the input.
    public static boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0)) return false;
        int rev=0;
        while(x>rev){
            rev*=10; rev+=x%10;
            x/=10;
        }
        if(rev==x || rev/10==x) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.print(isPalindrome(454));
    }
}
