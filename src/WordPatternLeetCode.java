import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 4/20/2017.
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 */
public class WordPatternLeetCode {

    public static boolean wordPattern(String pattern, String str) {
        HashMap<String, Character> map=new HashMap<>();
        HashSet<Character> used=new HashSet<>();
        String[] parts=str.split(" ");
        if(pattern.length()!=parts.length) return false;
        for(int i=0;i<parts.length;i++){
            String part=parts[i];
            if(!map.containsKey(part)){
                if(used.contains(pattern.charAt(i))) return false;
                else{
                    used.add(pattern.charAt(i));
                    map.put(part, pattern.charAt(i));
                }
            }
            else if(map.get(part)!=pattern.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(wordPattern("abab","dog cat dog cat"));
        System.out.println(wordPattern("abab","dog dog dog dog"));
    }
}
