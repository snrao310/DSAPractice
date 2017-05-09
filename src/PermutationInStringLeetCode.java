/**
 * Created by S N Rao on 5/6/2017.
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
 * one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 *
 */
public class PermutationInStringLeetCode {

    public static boolean checkInclusion(String s1, String s2) {
        int[] count=new int[26];
        for(int i=0;i<s1.length();i++)
            count[s1.charAt(i)-'a']++;
        for(int i=0;i<s2.length();i++){
            if(i<s1.length()){
                count[s2.charAt(i)-'a']--;
                if(i== s1.length()-1 && allZeroes(count)) return true;
            }
            else{
                count[s2.charAt(i-s1.length())-'a']++;
                count[s2.charAt(i)-'a']--;
                if(allZeroes(count)) return true;
            }
        }
        return false;
    }

    private static boolean allZeroes(int[] count){
        for(int i: count){
            if(i!=0) return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.print(checkInclusion("a","ab"));
    }

}
