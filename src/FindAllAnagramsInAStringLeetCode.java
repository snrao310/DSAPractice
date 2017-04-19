import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 4/19/2017.
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than
 * 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class FindAllAnagramsInAStringLeetCode {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(p.length()>s.length()) return res;
        int[] map=new int[26];
        for(int i=0;i<p.length();i++) map[p.charAt(i)-'a']++;
        int start=0;
        for(int i=0;i<s.length();i++){
            if(i>=p.length()) {
                map[s.charAt(start)-'a']++;
                start++;
            }
            map[s.charAt(i)-'a']--;
            if(allZeroes(map)) res.add(start);
        }
        return res;
    }

    private static boolean allZeroes(int[] map){
        for(int i:map) if(i!=0) return false;
        return true;
    }

    public static void main(String args[]){
        System.out.print(findAnagrams("abab","ab"));
    }
}
