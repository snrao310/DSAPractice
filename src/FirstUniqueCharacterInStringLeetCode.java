import java.util.HashMap;

/**
 * Created by S N Rao on 3/22/2017.
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 */
public class FirstUniqueCharacterInStringLeetCode {

    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> count=new HashMap<>();
        char[] st=s.toCharArray();
        for(char c:st) count.put(c,count.getOrDefault(c,0)+1);
        for(int i=0;i<st.length;i++) if(count.get(st[i])==1) return i;
        return -1;
    }

    public static void main(String args[]){
        System.out.print(firstUniqChar("lovechild"));
    }
}
