/**
 * Created by S N Rao on 3/27/2017.
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 */
public class ValidAnagramLeetCode {

    public static boolean isAnagram(String s, String t) {
        int[] alphabets=new int[26];
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        for(char i:s1) alphabets[i-'a']++;
        for(char i:t1) alphabets[i-'a']--;
        for(int i:alphabets) if(i!=0) return false;
        return true;
    }

    public static void main(String args[]){
        System.out.print(isAnagram("iamlordvoldemort","tommarvoloriddle"));
    }
}
