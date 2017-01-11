import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by snrao on 1/10/17.
 * <p>
 * <p>
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the
 * itinerary must begin with JFK.
 * <p>
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical
 * order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order
 * than ["JFK", "LGB"].
 * <p>
 * All airports are represented by three capital letters (IATA code).
 * <p>
 * You may assume all tickets form at least one valid itinerary.
 */
public class ReconstructItineraryLeetCode {

    public static List<String> findItinerary(String[][] tickets) {
        List<String> result=new ArrayList<>();
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] element : tickets) {
            graph.putIfAbsent(element[0],new PriorityQueue<>());
            graph.get(element[0]).add(element[1]);
        }
        traverse(graph,"JFK",result);
        return result;
    }

    private static void traverse(HashMap<String,PriorityQueue<String>> graph, String node,
                                 List<String> result){
        PriorityQueue<String> heap=graph.get(node);
        while (!heap.isEmpty() && heap!=null){
            traverse(graph,heap.poll(),result);
        }
        result.add(0,node);
    }

    public static void main(String args[]) {
        List<String> list = findItinerary(new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"},
                {"ATL", "JFK"}, {"ATL", "SFO"}});

//        List<String> list = findItinerary(new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}});

        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
