package Done;

import java.util.*;

/**
 * Created by S N Rao on 1/10/2017.
 *
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
 * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a
 * function to find all the MHTs and return a list of their root labels.
 *
 */
public class MinimumHeightTreeLeetCode {

    //The basic idea is "keep deleting leaves layer-by-layer, until reach the root." Specifically, first find all the leaves,
    // then remove them. After removing, some nodes will become new leaves. So we can continue remove them. Eventually, there
    // is only 1 or 2 nodes left. If there is only one node left, it is the root. If there are 2 nodes, either of them could be
    // a possible root. Time Complexity: Since each node will be removed at most once, the complexity is O(n).
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        if(edges.length==0){
            result.add(0);
            return result;
        }
        HashMap<Integer, HashSet<Integer>> graph=new HashMap<>();
        for(int i=0;i<n;i++) graph.put(i,new HashSet<>());
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> queue=new LinkedList();
        int visited=0;
        for(int i=0;i<n;i++){
            if(graph.get(i).size()==1) {
                queue.offer(i);
                visited++;
            }
        }
        queue.offer(null);

        while(visited!=n){
            while(queue.peek()!=null) {
                int node = queue.poll();
                HashSet<Integer> neighbors = graph.get(node);
                for (int i : neighbors) {
                    graph.get(i).remove(node);
                    if (graph.get(i).size() == 1) {
                        queue.offer(i);
                        visited++;
                    }
                }
            }
            if(!queue.isEmpty()) {
                queue.poll();
                queue.offer(null);
            }
        }

        while(!queue.isEmpty()) {
            if(queue.peek()!=null)
                result.add(queue.poll());
            else queue.poll();
        }
        return result;
    }

    public static void main(String args[]){
        List<Integer> list=findMinHeightTrees(6,new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        for(int i: list){
            System.out.print(i+" ");
        }
    }
}
