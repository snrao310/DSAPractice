import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 4/19/2017.
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No
 * two characters may map to the same character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 *
 * Note:
 * You may assume both s and t have the same length.
 *
 */
public class IsomorphicStringsLeetCode {

    public static boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map=new HashMap<>();
        HashSet<Character> used=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i), c2=t.charAt(i);
            if(!map.containsKey(c1)){
                if(used.contains(c2)) return false;
                else used.add(c2);
                map.put(c1,c2);
            }
            else if(map.get(c1)!=c2) return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(isIsomorphic("paper","title"));
        System.out.println(isIsomorphic("paper","titll"));
    }
}
