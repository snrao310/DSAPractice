/**
 * Created by S N Rao on 8/29/2017.
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 */
public class ValidPalindromeLeetCode2 {

    public static boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        s=s.toLowerCase();
        char[] st=s.toCharArray();
        int i=0,j=st.length-1;
        while(i<=j){
            if(!Character.isLetterOrDigit(st[i])) {i++; continue;}
            else if(!Character.isLetterOrDigit(st[j])) {j--; continue;}
            else if(st[i]!=st[j]) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
