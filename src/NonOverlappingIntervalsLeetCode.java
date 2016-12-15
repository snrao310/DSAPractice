import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by S N Rao on 12/14/2016.
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the
 * intervals non-overlapping.
 *
 * Nothing but Interval scheduling problem from FOA (Greedy algorithms).
 */
public class NonOverlappingIntervalsLeetCode {


    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {

        if(intervals.length==0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.end>o2.end)
                    return 1;
                if(o1.end<o2.end)
                    return -1;
                return 0;
            }
        });

        int result=0;
        int lastFinish=intervals[0].end;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start < lastFinish)
                result++;
            else
                lastFinish=intervals[i].end;
        }
        return result;
    }

    public static void main(String args[]) {
        Interval[] intervals={new Interval(1,2),new Interval(2,3)};
        System.out.print(eraseOverlapIntervals(intervals));
    }
}
