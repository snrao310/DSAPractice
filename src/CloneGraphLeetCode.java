import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by S N Rao on 1/19/2017.
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 *
 */
public class CloneGraphLeetCode {

//      Definition for undirected graph.
     class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
      }

    public class Solution {
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            HashMap<Integer,UndirectedGraphNode> map=new HashMap<>();
            if(node==null) return null;
            return cloneGraph(node,map);
        }

        private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> map){
            UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
            map.put(node.label,newNode);
            for(UndirectedGraphNode n: node.neighbors){
                if(!map.containsKey(n.label))
                    cloneGraph(n,map);
                newNode.neighbors.add(map.get(n.label));
            }
            return newNode;
        }
    }
}
