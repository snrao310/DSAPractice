import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by S N Rao on 3/24/2017.
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 */
public class SubstringWithConcatenationOfAllWordsLeetCode {

    //Naive method is to go through each index of s and check if substring of length equal wordLength contains words
    //from the list. If all words are there, then we add this index to list and go to next index and repeat. Complexity
    //of this will be O(n*wordLength*wordsInList) [those names are variables in the code]. This can be improved.
    //
    //Idea is that we don't have to start at all indices of s. We only iterate through the first wordLength indices of s.
    //Lets call this start. In each loop we check all the positions that are multiples of wordLength ahead of start. As
    //we go through the loop we find all the indices where there is an answer and add it to res list. In the next
    //iteration, we start with the next index start+1 and do the same. We do this for start goes from 0 to wordLength-1.
    //To understand all the cases of the algorithm, go through the example "foobarbarfoobarfur" with list of words,
    //words=["fur","foo","bar"].
    //
    //The complexity of this is O(n*wordLength). If the substring function was not there (if it was constant time
    //operation), we could have simplified this to O(wordLength * 2 * n/wordLength)=O(n). This is because, in each
    //iteration of the loop the j value increases by wordLength, and if the inner while loop is called left increases by
    //wordLength. So the whole thing is completed in 2*n/wordLength. But since substring function goes through all the
    //elements in between without skipping to index+wordLength, we need to take the iteration as 2n, and the total
    //complexity becomes O(n*wordLength).
    //
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if(s.length()==0 || words.length==0) return res;
        int wordsInList=words.length, n=s.length(), wordLength=words[0].length();
        HashMap<String,Integer> counts=new HashMap<>();
        for(String w:words) counts.put(w,counts.getOrDefault(w,0)+1);

        for(int i=0;i<wordLength;i++){
            HashMap<String,Integer> countInWindow=new HashMap<>();
            int left=i,count=0;
            for(int j=i;j<=n-wordLength;j+=wordLength){
                String part=s.substring(j,j+wordLength);
                if(counts.containsKey(part)){
                    countInWindow.put(part,countInWindow.getOrDefault(part,0)+1);
                    if(countInWindow.get(part)<=counts.get(part))
                        count++;
                    else{
                        count++;
                        while(countInWindow.get(part)>counts.get(part)){
                            String remove=s.substring(left,left+wordLength);
                            left+=wordLength;
                            countInWindow.put(remove,countInWindow.get(remove)-1);
                            count--;
                        }
                    }

                    if(count==wordsInList){
                        res.add(left);
                        part=s.substring(left,left+wordLength);
                        countInWindow.put(part,countInWindow.get(part)-1);
                        left+=wordLength;
                        count--;
                    }
                }
                else{
                    countInWindow.clear();
                    left=j+wordLength; count=0;
                }
            }
        }
        return res;
    }

    public static void main(String args[]){
        List<Integer> list=findSubstring("barfoothefoobarman",new String[]{"bar","foo"});
        for(int i:list)
            System.out.print(i+" ");
    }
}
