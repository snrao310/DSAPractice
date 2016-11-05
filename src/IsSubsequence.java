/**
 * Created by snrao on 11/5/16.
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
