/**
 * Created by S N Rao on 3/20/2017.
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 */
public class RansomNoteLeetCode {

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomArray=ransomNote.toCharArray(), magazineArray=magazine.toCharArray();
        int[] hashTable=new int[26];
        for(char i:magazineArray) hashTable[i-'a']++;
        for(char i:ransomArray){
            hashTable[i-'a']--;
            if(hashTable[i-'a']==-1) return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println(canConstruct("ab","abs"));
        System.out.println(canConstruct("ab","acs"));
    }
}
