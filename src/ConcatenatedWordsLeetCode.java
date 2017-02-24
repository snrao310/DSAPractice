import java.util.*;

/**
 * Created by S N Rao on 2/23/2017.
 *
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given
 * list of words.
 *
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 *
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 *
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 *
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 *
 */
public class ConcatenatedWordsLeetCode {

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashMap<String,Boolean> dp=new HashMap<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        HashSet<String> set=new HashSet<>();

        List<String> result=new ArrayList<>();
        for(String word: words){
            if(isConcat(word,dp,set))
                result.add(word);
            set.add(word);
        }
        return result;
    }

    private static boolean isConcat(String word, HashMap<String ,Boolean> dp, HashSet<String> set){
        if(set.contains(word))
            return true;

        if(dp.containsKey(word))
            return dp.get(word);

        StringBuilder sb=new StringBuilder(word);
        for(int i=0;i<sb.length()-1;i++){
            String part1=sb.substring(0,i+1);
            String part2=sb.substring(i+1);
            if(set.contains(part1)){
                if(isConcat(part2,dp,set)) {
                    dp.put(word, true);
                    return true;
                }
            }
        }
        dp.put(word,false);
        return false;
    }

    public static void main(String args[]){
        List<String> list=findAllConcatenatedWordsInADict(new String[]{"a","b","ab","abc"});
        for(String s: list)
            System.out.println(s);
    }
}
