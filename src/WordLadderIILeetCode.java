import java.util.*;

/**
 * Created by S N Rao on 3/31/2017.
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
public class WordLadderIILeetCode {

    //The basic idea is:
    // 1). Use BFS to find the shortest distance between start and end, tracing the number of steps (nodes of graph)
    // from start node to end node, and store each node's next level neighbors in HashMap. The key idea is to store only
    // the next level neighbors for DFS traversal (next step in the algorithm), and ignore all other neighbors. I did
    // this by maintaining another HashSet while doing BFS in addition to the general visited HashSet called
    // nextLevelNeighbors. When we see an unvisited neighbor node during BFS, we add it to visited, we add it to queue,
    // we add it to the nextLevelNeighbors and we add it to the dfs-neighbors map. When we see a visited node, we check
    // if it was added to visited during this level itself ie. if it exists in the nextLevelNeighbors HashSet. If it
    // exists, we add it to dfs-neighbors map. Every time a level is completed, we clear the nextLevelNeighbors HashSet.
    //
    // 2). Use DFS with backtracking to traverse all paths with the same distance (number of steps/nodes obtained from
    // BFS) and add the path to the list if it leads to the end node (endWord).
    //
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result=new ArrayList<>();
        HashSet<String> dict=new HashSet<>();
        for(String w:wordList)dict.add(w);
        HashMap<String,List<String>> neighbors=new HashMap<>();
        int minSteps=BFS(dict,neighbors,beginWord,endWord);

        HashSet<String> visited=new HashSet<>();
        List<String> tempList=new ArrayList<>(Arrays.asList(beginWord));
        visited.add(beginWord);
        DFS(beginWord,endWord,neighbors,result,tempList,visited,1,minSteps);
        return result;
    }

    private static int BFS(HashSet<String> dict,HashMap<String,List<String>> neighbors,String beginWord, String endWord){
        HashSet<String> visited=new HashSet<>();
        HashSet<String> nextLevelNodes=new HashSet<>();
        int minSteps=1, count=1;
        boolean found=false;
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord); queue.offer(null); visited.add(beginWord);
        while(!queue.isEmpty()){
            String cur=queue.poll();
            if(cur!=null){
                neighbors.put(cur,new ArrayList<>());
                char[] curArr=cur.toCharArray();
                for(int i=0;i<curArr.length;i++){
                    char c=curArr[i];
                    for(char replace='a';replace<='z';replace++){
                        if(replace==c) continue;
                        curArr[i]=replace;
                        String temp=new String(curArr);
                        if(dict.contains(temp)){
                            if(!visited.contains(temp)){
                                neighbors.get(cur).add(temp);   //Next level node. So add it to neighbors.
                                queue.offer(temp);
                                visited.add(temp);
                                nextLevelNodes.add(temp);   //This node is in the next level
                                if(!found && temp.equals(endWord)){
                                    found=true; minSteps=count+1;
                                }
                            }
                            else if(nextLevelNodes.contains(temp)){     //If the node is visited but is in the next level,
                                neighbors.get(cur).add(temp);           //it must be added to neighbors.
                            }
                        }
                        curArr[i]=c;
                    }
                }
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
                count++;
                nextLevelNodes.clear();
            }
        }
        return minSteps;
    }

    private static void DFS(String cur,String endWord,HashMap<String,List<String>> dfsNeighbors,
                            List<List<String>> list,List<String> tempList,
                            HashSet<String> visited, int steps,int minSteps){

        if(steps==minSteps && cur.equals(endWord)){
            list.add(new ArrayList<>(tempList));
            return;
        }
        if(steps>=minSteps)
            return;
        List<String> neigh=dfsNeighbors.get(cur);
        for(String s:neigh){
            if(!visited.contains(s)){
                tempList.add(s); visited.add(s);
                DFS(s,endWord,dfsNeighbors,list,tempList,visited,steps+1,minSteps);
                tempList.remove(s); visited.remove(s);
            }
        }
    }

    public static void main(String args[]){
        List<String> wordList=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        List<List<String>> list=findLadders("hit","cog",wordList);
        for(List<String> l:list)
            System.out.println(l);
    }
}
