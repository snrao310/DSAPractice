import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by S N Rao on 2/8/2017.
 *
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list
 * of disjoint intervals.
 *
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 *
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 *
 */
public class DataStreamAsDisjointIntervalsLeetCode {


    //Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    //The class
    public static class SummaryRanges {
        TreeMap<Integer,Integer> bst; //Start to End

        /** Initialize your data structure here. */
        public SummaryRanges() {
            bst=new TreeMap<>();
        }

        public void addNum(int val) {
            Integer aStart,bStart,aEnd=null,bEnd=null;
            aStart=bst.floorKey(val);
            bStart=bst.ceilingKey(val);
            if(aStart!=null)aEnd=bst.get(aStart);
            if(bStart!=null)bEnd=bst.get(bStart);

            //Both floor and ceiling are null
            if(aStart==null && bStart==null)
                bst.put(val, val);

                //floor is null
            else if(aStart==null){
                if(val==bStart-1){
                    bst.remove(bStart);
                    bst.put(val, bEnd);
                }
                else
                    bst.put(val, val);
            }

            //Ceiling is null
            else if(bStart==null){
                if(val==aEnd+1)
                    bst.put(aStart, val);
                else if(val>aEnd)
                    bst.put(val, val);
            }

            //Both floor and ceiling are not null
            else{
                if(val==aEnd+1 && val==bStart-1){
                    bst.remove(bStart);
                    bst.put(aStart, bEnd);
                }
                else if(val==aEnd+1)
                    bst.put(aStart, val);
                else if(val==bStart-1){
                    bst.remove(bStart);
                    bst.put(val, bEnd);
                }
                else if(val>aEnd)
                    bst.put(val, val);
            }
        }

        public List<Interval> getIntervals() {
            List<Interval> res=new ArrayList<>();
            for(int i: bst.keySet())
                res.add(new Interval(i,bst.get(i)));
            return res;
        }
    }

    public static void main(String[] args) {
        /**
         * Your SummaryRanges object will be instantiated and called as such:
         * SummaryRanges obj = new SummaryRanges();
         * obj.addNum(val);
         * List<Interval> param_2 = obj.getIntervals();
         */

        SummaryRanges obj=new SummaryRanges();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(7);
        List<Interval> l1 = obj.getIntervals();
        for(Interval i: l1) System.out.print("["+i.start+", "+i.end+"] ");
        System.out.println();
        obj.addNum(2);
        l1 = obj.getIntervals();
        for(Interval i: l1) System.out.print("["+i.start+", "+i.end+"] ");
        System.out.println();
        obj.addNum(6);
        l1 = obj.getIntervals();
        for(Interval i: l1) System.out.print("["+i.start+", "+i.end+"] ");
    }

}