import java.util.*;
import java.util.Queue;


/**
 * Created by S N Rao on 2/5/2017.
 */
public class GraphImplementation {

    public static class GraphList{
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
    }

    public static void addNode(GraphList g, int n){
        g.graph.put(n, new ArrayList<Integer>());
    }

    public static void addEdge(GraphList g, int i, int j){
        if(g.graph.containsKey(i)&&g.graph.containsKey(j)){	//assuming no duplicate edges will be added.
            g.graph.get(i).add(j);							//and assuming this is an undirected graph
            g.graph.get(j).add(i);
        }
    }

    public static void printConnectedComponents(GraphList g){
        HashSet<Integer> visited=new HashSet<>();
        for(int i:g.graph.keySet()){
            if(!visited.contains(i)){
                visited.add(i);
                System.out.print(i+" ");
                dfs(g,i,visited);
                System.out.println();
            }
        }

        System.out.println();

        visited.clear();
        for(int i:g.graph.keySet()){
            if(!visited.contains(i)){
                visited.add(i);
                System.out.print(i+" ");
                bfs(g,i,visited);
                System.out.println();
            }
        }
    }

    private static void dfs(GraphList g, int i, HashSet<Integer> visited){

        List<Integer> neigh=g.graph.get(i);
        for(int n:neigh){
            if(!visited.contains(n)){
                visited.add(n);
                System.out.print(n+" ");
                dfs(g,n,visited);
            }
        }
    }


    private static void bfs(GraphList g, int i, HashSet<Integer> visited){
        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int cur=q.poll();
            List<Integer> neigh=g.graph.get(cur);
            for(int n:neigh){
                if(!visited.contains(n)){
                    visited.add(n);
                    System.out.print(n+" ");
                    q.offer(n);
                }
            }
        }
    }

    public static void main(String args[]){
        GraphList g=new GraphList();
        addNode(g,4);
        addNode(g,5);
        addNode(g,3);
        addNode(g,7);
        addNode(g,8);
        addNode(g,6);
        addNode(g,9);
        addNode(g,2);
        addNode(g,1);

        addEdge(g,4,5);
        addEdge(g,4,3);
        addEdge(g,5,7);
        addEdge(g,7,3);
        addEdge(g,8,6);
        addEdge(g,2,9);

        printConnectedComponents(g);
    }

}
