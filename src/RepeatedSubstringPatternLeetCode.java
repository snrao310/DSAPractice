/**
 * Created by S N Rao on 4/11/2017.
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of
 * the substring together. You may assume the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */
public class RepeatedSubstringPatternLeetCode {

    public static boolean repeatedSubstringPattern(String s) {
        for(int j=1;j<s.length()/2+1;j++){
            if(s.length()%j==0){
                StringBuilder sb=new StringBuilder();
                String part=s.substring(0,j);
                while(sb.length()!=s.length())sb.append(part);
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(repeatedSubstringPattern("abab"));
    }
}
