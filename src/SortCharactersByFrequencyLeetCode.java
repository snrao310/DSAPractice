import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by S N Rao on 2/6/2017.
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Note that 'A' and 'a' are treated as two different characters.
 *
 */
public class SortCharactersByFrequencyLeetCode {

    //Same as Top K Frequent elements but with character instead of integers, no k limit, just sort in order and return.
    //Can also use the heap solution in this. But implementing only the better solution here.
    public static String frequencySort(String s) {
        List<Character>[] freqToNums=new List[s.length()+1];
        HashMap<Character,Integer> numsToFreq=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            numsToFreq.put(c, numsToFreq.getOrDefault(c, 0)+1);
        }

        for(char c:numsToFreq.keySet()){
            int freq=numsToFreq.get(c);
            if(freqToNums[freq]==null)
                freqToNums[freq]=new ArrayList<>();
            freqToNums[freq].add(c);
        }

        StringBuilder result = new StringBuilder();
//        String result=""; Tried this. Time limit gets exceeded. Check following comment
        for(int i=s.length();i>=0;i--){
            if(freqToNums[i]==null) continue;
            for(char c:freqToNums[i]){
                for(int j=0;j<i;j++)
                    result.append(c);
//        			result+=c;	Tried this. Time limit exceeded. Because when you make changes to a string, it has to create new
//        						String in memory and then add character to it. This is time consuming.
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("AaBbbccc"));
    }
}

