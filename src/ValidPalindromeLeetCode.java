/**
 * Created by S N Rao on 4/25/2017.
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
public class ValidPalindromeLeetCode {

    public static boolean isPalindrome(String s) {
        char[] st=s.toCharArray();
        int i=0, j=st.length-1;
        while(i<j){
            char c1=st[i], c2=st[j];
            if(!isValid(c1)) {i++; continue;}
            else c1=Character.toLowerCase(c1);

            if(!isValid(c2)) {j--; continue;}
            else c2=Character.toLowerCase(c2);

            if(c1!=c2) return false;
            else{i++; j--;}
        }
        return true;
    }

    private static boolean isValid(Character c){
        if(Character.isAlphabetic(c)) return true;
        if(Character.isDigit(c)) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
