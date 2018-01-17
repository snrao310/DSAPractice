/**
 * Created by S N Rao on 11/21/2017.
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 */
public class PalindromeNumberLeetCode2 {


    public static boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0)) return false;
        int rev=0;
        while(rev<x){
            rev=(rev*10)+(x%10);
            x/=10;
        }
        if(rev==x || rev/10==x) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.println(isPalindrome(45567));
        System.out.println(isPalindrome(4554));
    }
}
