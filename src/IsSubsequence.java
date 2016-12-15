/**
 * Created by snrao on 11/5/16.
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long
 * (length ~= 500,000) string, and s is a short string (<=100).
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence
 * of "abcde" while "aec" is not).
 *
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (j < s.length() && i < t.length()) {
            if (s.charAt(j) == t.charAt(i))
                j++;
            i++;
        }
        if (j == s.length())
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.print(isSubsequence("abc","aadfbsdfscdf"));
    }

}
