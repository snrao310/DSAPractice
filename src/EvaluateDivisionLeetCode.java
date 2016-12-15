import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by S N Rao on 12/15/2016.
 *
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real
 * number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 */
public class EvaluateDivisionLeetCode {

    public static class Graph {
        public class EdgeTo {
            String edgeTo;
            double val;
        }

        HashMap<String, List<EdgeTo>> graph = new HashMap();

        public void addVertex(String s) {
            if (graph.containsKey(s))
                return;
            graph.put(s, new ArrayList<>());
        }

        public void addEdge(String a, String b, double val) {
            if (!graph.containsKey(a) || !graph.containsKey(b))
                return;
            List<EdgeTo> edgeList = graph.get(a);
            EdgeTo e = new EdgeTo();
            e.edgeTo = b;
            e.val = val;
            edgeList.add(e);
        }

        public double findPathWithValue(String a,String b){
            if(!graph.containsKey(a) || !graph.containsKey(b))
                return -1;
            return findPathRecurse(a,b,new HashSet<>());
        }

        public double findPathRecurse(String a,String b, HashSet<String > visited){
            visited.add(a);
            if(a.equals(b)) {
                return 1;
            }
            for(EdgeTo e: graph.get(a)){
                if(!visited.contains(e.edgeTo)){
                    double val=findPathRecurse(e.edgeTo,b,visited);
                    if(val>=0)
                        return e.val*val;
                }
            }
            return -1;
        }
    }


    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] result = new double[queries.length];

        Graph equationGraph = new Graph();
        for (int i = 0; i < equations.length; i++) {
            String[] eq = equations[i];
            equationGraph.addVertex(eq[0]);
            equationGraph.addVertex(eq[1]);
            equationGraph.addEdge(eq[0], eq[1], values[i]);
            equationGraph.addEdge(eq[1], eq[0], (1 / values[i]));
        }

        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            result[i] = equationGraph.findPathWithValue(a, b);
        }

        return result;
    }

    public static void main(String args[]) {
        String[][] eq = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] que = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double[] ans = calcEquation(eq, values, que);
        for (double i : ans) {
            System.out.print(i + " ");
        }
    }
}
