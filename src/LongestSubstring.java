import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;

/**
 * Created by snrao on 9/17/16.
 */
public class LongestSubstring {

    public static void main (String args[]){
        String s="abcdaefb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Boolean> hashMap = new HashMap<Character, Boolean>();

        int length = s.length();

        int pointer1 = 0;
        int pointer2 = 0;
        int maxLength = 0;
        while (pointer2 < length) {
            if (hashMap.containsKey(s.charAt(pointer2))) {
                while (s.charAt(pointer1) != s.charAt(pointer2)) {
                    hashMap.remove(s.charAt(pointer1));
                    pointer1++;
                }
                pointer1++;
                pointer2++;
            } else {
                hashMap.put(s.charAt(pointer2), true);
                pointer2++;
            }
            if (pointer2 - pointer1  > maxLength) {
                maxLength = pointer2 - pointer1;
            }
        }
        return maxLength;
    }

}
