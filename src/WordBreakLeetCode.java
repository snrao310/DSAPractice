import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by snrao on 1/3/17.
 *
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence
 * of one or more dictionary words.
 *
 *
 */
public class WordBreakLeetCode {

    public static boolean wordBreak(String s, Set<String> wordDict) {
        HashMap<String,Boolean> map=new HashMap();
        for(String k: wordDict) map.put(k,true);
        return wordBreakRecurse(s,map);
    }

    public static boolean wordBreakRecurse(String s, HashMap<String,Boolean> map){
        if(s.length()==0) return false;
        if(map.containsKey(s)) return map.get(s);
        for(int i=1;i<s.length();i++){
            String first=s.substring(0,i);
            if(map.containsKey(first) && map.get(first)){
                if(wordBreakRecurse(s.substring(i),map)){
                    map.put(s.substring(i),true);
                    return true;
                }
            }
        }
        map.put(s,false);
        return false;
    }


    public static void main(String args[]){
        Set<String > set=new HashSet<>();
        set.add("leet");
        set.add("code");
        wordBreak("leetcode",set);
    }
}
