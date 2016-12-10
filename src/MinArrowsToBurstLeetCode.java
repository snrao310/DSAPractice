import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by snrao on 12/9/16.
 *
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input
 * is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't
 * matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than
 * end. There will be at most 104 balloons.

 An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart
 and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that
 can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number
 of arrows that must be shot to burst all balloons.
 */
public class MinArrowsToBurstLeetCode {

    public static int findMinArrowShots(int[][] points) {
        int minArrows=0;
        if(points.length==0)
            return minArrows;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0])
                    return 1;
                else if(o1[0]<o2[0])
                    return -1;
                return 0;
            }
        });

        minArrows=1;
        int arrowCover=points[0][1];
        for(int i=1;i<points.length;i++){
            if(arrowCover<points[i][0]) {
                minArrows++;
                arrowCover = points[i][1];
            }
            else{
                arrowCover=Math.min(arrowCover,points[i][1]);
            }

        }

        return minArrows;
    }

    public static void main(String args[]){
        int[][] mat={{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(mat));
    }
}
