import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 3/2/2017.
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 */
public class InsertIntervalLeetCode {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int newIntStart=newInterval.start, newIntEnd=newInterval.end, prev=-1, next=-1;
        boolean isPrevStart=false, isNextStart=false;

        //prev is last index smaller than newIntStart, next is first index larger than newIntEnd.
        //isPrevStart is true if the prev interval's start is the last index smaller than newIntStart, false if its interval's end.
        //isNextStart is true if the next interval's start is the first index larger than newIntEnd, false if its interval's end.
        for(int i=0;i<intervals.size();i++){
            Interval interval=intervals.get(i);
            if(interval.start<newIntStart){prev=i; isPrevStart=true;}
            if(interval.end<newIntStart){prev=i; isPrevStart=false;}
            if(interval.start<=newIntEnd){next=i; isNextStart=false;}
            if(interval.end<=newIntEnd){next=i+1; isNextStart=true;}
        }


        //Edge cases
        //Adding to beginning.
        if(next==-1){
            intervals.add(0,new Interval(newIntStart,newIntEnd));
            return intervals;
        }
        //Adding to end
        if(prev==intervals.size()-1 && !isPrevStart){
            intervals.add(intervals.size(),new Interval(newIntStart,newIntEnd));
            return intervals;
        }
        //Adding to beginning but newIntEnd is in between the list.
        if(prev==-1){
            intervals.add(0,new Interval(newIntStart,newIntStart));
            prev=0;isPrevStart=true;next++;
        }
        //Adding in end but newIntStart is in between the list.
        if(next==intervals.size()){
            intervals.add(intervals.size(), new Interval(newIntEnd, newIntEnd));
            next = intervals.size() - 1;
            isNextStart = false;
        }
        //intervals at prev and next indices.
        Interval first=intervals.get(prev);
        Interval second=intervals.get(next);


        //Different cases
        //prev is start of interval and next is end of interval.
        if(isPrevStart && !isNextStart){
            first.end=second.end;
            int toDelete=next-prev;
            while(toDelete-->0)
                intervals.remove(prev+1);
        }
        //both prev and next are start of interval.
        else if(isPrevStart && isNextStart){
            first.end=newIntEnd;
            int toDelete=next-prev-1;
            while(toDelete-->0)
                intervals.remove(prev+1);
        }
        //both prev and next are end of interval.
        else if(!isPrevStart && !isNextStart){
            second.start=newIntStart;
            int toDelete=next-prev-1;
            while(toDelete-->0)
                intervals.remove(prev+1);
        }
        //prev is end of interval and next is start of interval.
        else if(!isPrevStart && isNextStart){
            int toDelete=next-prev-1;
            while(toDelete-->0)
                intervals.remove(prev+1);
            intervals.add(prev+1,new Interval(newIntStart,newIntEnd));
        }

        return intervals;
    }

    public static void main(String args[]){
        List<Interval> list=new ArrayList<>();
        list.add(new Interval(1,2));
        list.add(new Interval(3,5));
        list.add(new Interval(6,7));
        list.add(new Interval(8,10));
        list.add(new Interval(12,16));
        list=insert(list,new Interval(8,12));
        for(Interval i: list)
            System.out.println(i.start+" "+i.end);
    }
}
