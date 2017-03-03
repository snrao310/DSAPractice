import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by S N Rao on 3/3/2017.
 *
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a
 * distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo
 * (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 *
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are
 * the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed
 * that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles
 * grounded on an absolutely flat surface at height 0.
 *
 * For instance, the dimensions of all buildings in Figure A are recorded as:
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 *
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has
 * zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 *
 * For instance, the skyline in Figure B should be represented as:
 * [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 *
 * Notes:
 *
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance,
 * [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one
 * in the final output as such: [...[2 3], [4 5], [12 7], ...]
 */
public class TheSkylineProblemLeetCode {

    //Complexity: Every building gets added and polled out of heap once. The complexity pushing is logn in worst case
    //if every building is in the heap. So the overall complexity is O(nlogn). The key is reducing complexity of deletion
    //Deleting of buildings that no longer matter from the heap happens only when they come to the root. Else finding and
    //deleting in heap is O(n) operation.
    public static List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length==0) return new ArrayList<>();

        //Heap to store all buildings till this point and returns one with max height
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });

        List<int[]> result = new ArrayList<>();
        int[] cur = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int i = 0, len = buildings.length;

        //iterates through the list, stopping when either a building ends or another building starts (nextChange variable).
        //At these points decides if which building is highest from heap, updates heap, results list and goes on.
        //cases to take care of: heap gets empty meaning there is gap between buildings, no more buildings ie how to stop  the loop.
        while (i < len || !heap.isEmpty()) {
            if (heap.isEmpty()) {
                int nextChange = buildings[i][0];
                while (i!=len && buildings[i][0]==nextChange)
                    heap.add(buildings[i++]);
                cur = heap.peek();
                result.add(new int[]{cur[0], cur[2]});
                continue;
            }

            int nextChange = cur[1];
            if (i != len)
                nextChange = Math.min(cur[1], buildings[i][0]);

            if (i != len && nextChange == buildings[i][0]) {
                while(i!=len && buildings[i][0]==nextChange)
                    heap.add(buildings[i++]);
            }

            //Deleting all the old buildings whose right has ended before this point if they are at the root.
            while (!heap.isEmpty() && heap.peek()[1] <= nextChange)
                heap.poll();

            if (heap.isEmpty())
                result.add(new int[]{nextChange, 0});
            else {
                if (heap.peek()[2] != cur[2])
                    result.add(new int[]{nextChange, heap.peek()[2]});
                cur = heap.peek();

            }
        }
        return result;
    }

    public static void main(String args[]) {
        List<int[]> skyline = getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        for (int[] arr : skyline)
            System.out.println(arr[0] + " " + arr[1]);
    }
}
