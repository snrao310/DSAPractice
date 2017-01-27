import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by S N Rao on 1/26/2017.
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 */
public class MergeIntervalsLeetCode {

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

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==0 || intervals.size()==1) return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start>o2.start)
                    return 1;
                if(o1.start<o2.start)
                    return -1;
                return 0;
            }
        });
        List<Interval> result=new ArrayList<>();
        result.add(intervals.get(0));
        int lastFinish=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            Interval cur=intervals.get(i);
            if(cur.start<=lastFinish) {
                lastFinish = Math.max(lastFinish, cur.end);
                result.get(result.size() - 1).end=lastFinish;
            }
            else{
                result.add(cur);
                lastFinish=cur.end;
            }
        }
        return result;
    }

    public static void main(String args[]){
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        list=merge(list);
        for(Interval i: list){
            System.out.println("["+i.start+","+i.end+"]");
        }
    }
}
