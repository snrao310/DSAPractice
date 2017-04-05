import java.util.*;

/**
 * Created by S N Rao on 4/5/2017.
 *
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
 * some characters of the given string. If there are more than one possible results, return the longest word with the
 * smallest lexicographical order. If there is no possible result, return the empty string.
 *
 * Example 1:
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:
 * "apple"
 *
 * Example 2:
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 * Output:
 * "a"
 *
 * Note:
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 *
 */
public class LongestWordInDictionaryThroughDeletingLeetCode {

    //Sort dict reverse by length and for same length, sort lexicographically. Then scan dict and check if any of them
    //is a subsequence of string.
    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                if(o1.length()!=o2.length())
                    return o2.length()-o1.length(); //descending if different length
                else
                    return o1.compareTo(o2); //ascending lexicographical if same length.
            }
        });

        for(String d1: d){
            if(d1.length()>s.length()) continue;
            if(isSubsequence(d1,s))
                return d1;
        }
        return "";
    }

    private static boolean isSubsequence(String s1, String s2){
        int i=0;
        for(int j=0;j<s2.length();j++){
            if(s1.charAt(i)==s2.charAt(j))
              i++;
            if(i==s1.length()) return true;
        }
        return false;
    }

    public static void main(String args[]){
        List<String> dict=new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        System.out.println(findLongestWord("abpcplea",dict));

        dict=new ArrayList<>(Arrays.asList("a","b","c"));
        System.out.println(findLongestWord("abpcplea",dict));
    }
}
