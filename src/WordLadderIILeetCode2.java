import java.util.*;

/**
 * Created by S N Rao on 8/16/2017.
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s)
 * from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 *
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code
 * definition to get the latest changes.
 *
 */
public class WordLadderIILeetCode2 {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result=new ArrayList<>();
        HashSet<String> dict=new HashSet<>();
        for(String s: wordList)
            dict.add(s);

        HashMap<String, List<String>> dfsNeighbors=new HashMap<>();
        int minSteps=BFS(beginWord,endWord,dict,dfsNeighbors);

        HashSet<String> visited=new HashSet<>();
        List<String> tempList=new ArrayList<>();
        visited.add(beginWord); tempList.add(beginWord);
        DFS(beginWord,endWord,dfsNeighbors,visited,result,tempList,minSteps,0);
        return result;
    }

    private static void DFS(String curWord, String endWord, HashMap<String, List<String>> dfsNeighbors, HashSet<String> visited,
                           List<List<String>> result, List<String> tempList,int minSteps, int steps) {
        if(steps==minSteps && curWord.equals(endWord)) {
            result.add(new ArrayList<String>(tempList));
            return;
        }

        if(steps>=minSteps)
            return;

        for(String s: dfsNeighbors.get(curWord)){
            if(!visited.contains(s)){
                visited.add(s);
                tempList.add(s);
                DFS(s, endWord, dfsNeighbors, visited, result, tempList, minSteps, steps + 1);
                visited.remove(s);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    private static int BFS(String beginWord, String endWord, HashSet<String> dict, HashMap<String, List<String>> dfsNeighbors){
        HashSet<String> visited=new HashSet<>(), nextLevelNeighbors=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord); queue.offer(null); visited.add(beginWord);
        int minSteps=0;
        boolean found=false;

        while(!queue.isEmpty()){
            String cur=queue.poll();
            if(cur!=null){
                dfsNeighbors.put(cur,new ArrayList<>());
                char[] str=cur.toCharArray();
                for(int i=0;i<str.length;i++){
                    for(char replace='a'; replace<='z';replace++){
                        if(str[i]==replace) continue;
                        else{
                            char c=str[i];
                            str[i]=replace;
                            String replacedStr=String.valueOf(str);
                            if(!dict.contains(replacedStr)) {str[i]=c; continue;}
                            if(!visited.contains(replacedStr)){
                                if(!found && replacedStr.equals(endWord))
                                    found=true;
                                visited.add(replacedStr);
                                queue.add(replacedStr);
                                dfsNeighbors.get(cur).add(replacedStr);
                                nextLevelNeighbors.add(replacedStr);
                            }
                            else{
                                if(nextLevelNeighbors.contains(replacedStr))
                                    dfsNeighbors.get(cur).add(replacedStr);
                            }
                            str[i]=c;
                        }
                    }
                }
            }
            else{
                if(!queue.isEmpty())
                    queue.add(null);
                minSteps++;
                nextLevelNeighbors.clear();
                if(found)
                    break;
            }
        }
        return minSteps;
    }



    public static void main(String args[]){
        List<String> wordList=new ArrayList<>(Arrays.asList("hot","cog","dot","dog","hit","lot","log"));
        List<List<String>> list=findLadders("hit","cog",wordList);
        for(List<String> l:list)
            System.out.println(l);
    }
}
