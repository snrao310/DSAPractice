import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by S N Rao on 3/2/2017.
 *
 * Total Accepted: 59364
 * Total Submissions: 208516
 * Difficulty: Hard
 * Contributors: Admin
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *       great
 *      /    \
 *     gr    eat
 *    / \    /  \
 *   g   r  e   at
 *  / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *       rgeat
 *      /    \
 *     rg    eat
 *    / \    /  \
 *   r   g  e   at
 *  / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *       rgtae
 *      /    \
 *     rg    tae
 *    / \    /  \
 *   r   g  ta  e
 *  / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 */
public class ScrambleStringLeetCode {

    public static boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> dp=new HashMap<>();
        return dpFunction(s1,s2,dp);
    }

    private static boolean dpFunction(String s1, String s2, HashMap<String,Boolean> dp){
        if(s1.equals(s2)) return true;
        if(dp.containsKey(s1+" "+s2))
            return dp.get(s1+" "+s2);

        if(s1.length()!=s2.length()) return false;
        int[] letters=new int[26];
        for(int i=0;i<s1.length();i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for(int i:letters)
            if(i!=0) return false;

        for(int i=1;i<s1.length();i++){
            if(dpFunction(s1.substring(0,i),s2.substring(0,i),dp) &&
                    dpFunction(s1.substring(i),s2.substring(i),dp)) {
                dp.put(s1+" "+s2, true);
                return true;
            }
            if(dpFunction(s1.substring(0,i),s2.substring(s2.length()-i),dp) &&
                    dpFunction(s1.substring(i),s2.substring(0,s2.length()-i),dp)){
                dp.put(s1+" "+s2, true);
                return true;
            }
        }

        dp.put(s1+" "+s2, false);
        return false;
    }

    public static void main(String args[]){
        System.out.println(isScramble("great","rgtae"));
        System.out.println(isScramble("great","rtgae"));
    }
}
