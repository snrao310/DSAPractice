/**
 * Created by S N Rao on 3/27/2017.
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can
 * be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 */
public class LongestPalindromeLeetCode {

    public static int longestPalindrome(String s) {
        int[] alphabet=new int[58];
        char[] s1=s.toCharArray();
        for(char i:s1) alphabet[i-'A']++;

        int result=0;
        boolean oddExists=false;
        for(int i:alphabet){
            if((i&1)==0) //even
                result+=i;
            else{
                oddExists=true;
                result+=i-1;
            }
        }
        if(oddExists)
            result++;
        return result;
    }

    public static void main(String args[]){
        System.out.println(longestPalindrome("abccccdd"));
    }
}
