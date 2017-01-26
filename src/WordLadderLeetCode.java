import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

import java.util.*;

/**
 * Created by S N Rao on 1/24/2017.
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 */
public class WordLadderLeetCode {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len=beginWord.length(),result=1;
        HashSet<String> visited=new HashSet<>();
        HashSet<String> words=new HashSet<>();
        for(String s: wordList) words.add(s);
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(null);
        while(!queue.isEmpty()){
            String cur=queue.poll();
            if(cur!=null){
                char[] charRep=cur.toCharArray();
                for(int i=0;i<charRep.length;i++){
                    char c=charRep[i];
                    for(char replace='a';replace<='z';replace++){
                        if(replace==c) continue;
                        charRep[i]=replace;
                        String temp=new String(charRep);
                        if(words.contains(temp) && !visited.contains(temp)){
                            if(temp.equals(endWord))
                                return result+1;
                            visited.add(temp);
                            queue.offer(temp);
                        }
                        charRep[i]=c;
                    }
                }
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
                result++;
            }
        }
        return 0;
    }

    public static void main(String args[]){
        List<String> wordList=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength("hit","cog",wordList));
    }
}
