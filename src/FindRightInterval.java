import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by snrao on 11/5/16.
 */

/*
Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.

Note:
You may assume the interval's end point is always bigger than its start point.
You may assume none of these intervals have the same start point.
 */

public class FindRightInterval {


    public static class Arr{
        boolean start;
        int index;
        int val;
    }


    public static int[] findRightInterval(int[][] intervals) {
        Arr arr[]=new Arr[2*intervals.length];
        for(int i = 0; i < arr.length ; i++)
        {
            arr[i] = new Arr();
        }

        int k=0;
        for(int i=0;i<intervals.length;i++){
            arr[k].val = intervals[i][0];
            arr[k].index=i;
            arr[k].start=true;
            arr[k+1].val=intervals[i][1];
            arr[k+1].start=false;
            arr[k+1].index=i;

            k+=2;
        }


        //sort arr
        Arrays.sort(arr, new Comparator<Arr>() {
            @Override
            public int compare(Arr o1, Arr o2) {
                if(o1.val>o2.val)
                    return 1;
                else if(o1.val==o2.val)
                    if(o1.start)
                        return 1;
                    else
                        return -1;
                return -1;
            }
        });


        int curr_start=-1;
        int res[]=new int[intervals.length];
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i].start)
                curr_start=arr[i].index;
            else
                res[arr[i].index]=curr_start;
        }
        return res;
    }

    public static void main(String[] args){
        int intervals[][]={{3,4},{2,3},{1,2}};
        int res[]=findRightInterval(intervals);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+ " ");
        }
    }



}
