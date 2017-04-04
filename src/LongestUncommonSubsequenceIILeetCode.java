import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by S N Rao on 4/4/2017.
 *
 * Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon
 * subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any
 * subsequence of the other strings.
 *
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the
 * order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a
 * subsequence of any string.
 *
 * The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence. If
 * the longest uncommon subsequence doesn't exist, return -1.
 *
 * Example 1:
 * Input: "aba", "cdc", "eae"
 * Output: 3
 *
 * Note:
 * All the given strings' lengths will not exceed 10.
 * The length of the given list will be in the range of [2, 50].
 *
 */
public class LongestUncommonSubsequenceIILeetCode {


    //The key is realizing that the subsequence has to be one of the strings in the array itself. Sort it by lengths.
    //The longest string will be the result if it has no duplicate. If there is a duplicate, then it can never be the
    //result and neither can any of its subsequences. If that's the case, then second longest string will be the result
    //if there are no duplicates and its not a subsequence of any of the larger strings. If there is a duplicate, again,
    //it and its subsequences will never be the result; and if its a subsequence of a larger string, then again, it and
    //its subsequences will never be the result. So keep iterating through the sorted array till you find a string that
    //doesn't have duplicates and is not a subsequence of any of the longer strings.
    public static int findLUSlength(String[] strs) {
        HashSet<String> duplicates=new HashSet<>();
        getDuplicates(strs, duplicates);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()- o1.length();    //Reverse sort
            }
        });

        for(int i=0;i<strs.length;i++){
            if(!duplicates.contains(strs[i])){
                boolean subSeq=false;
                for(int j=0;j<i;j++){
                    if(isSubsequence(strs[i],strs[j])){
                        subSeq=true; break;
                    }
                }
                if(!subSeq) return strs[i].length();
            }
        }
        return -1;
    }

    private static boolean isSubsequence(String s1, String s2){
        int i=0;
        for(int j=0;j<s2.length();j++){
            if(s2.charAt(j)==s1.charAt(i))
                i++;
            if(i==s1.length()) return true;
        }
        return false;
    }

    private static void getDuplicates(String[] strs, HashSet<String> duplicates){
        HashSet<String> check=new HashSet<>();
        for(String s: strs){
            if(check.contains(s))
                duplicates.add(s);
            else check.add(s);
        }
    }

    public static void main(String args[]){
        System.out.println(findLUSlength(new String[]{"aba", "cdc", "eae"}));
    }
}
