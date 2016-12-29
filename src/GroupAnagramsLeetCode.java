import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by snrao on 12/28/16.
 *
 * Given an array of strings, group anagrams together.
 *
 */
public class GroupAnagramsLeetCode {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String >> map=new HashMap<>();
        for(String s:strs){
            char[] st=s.toCharArray();
            Arrays.sort(st);
            String key= String.valueOf(st);
            if(map.containsKey(key)) map.get(key).add(s);
            else {
                map.put(key,new ArrayList<String >());
                map.get(key).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String args[]){
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> l=groupAnagrams(strs);
        for(List<String> li:l){
            for(String s:li)
                System.out.print(s+" ");
            System.out.println();
        }
    }
}
