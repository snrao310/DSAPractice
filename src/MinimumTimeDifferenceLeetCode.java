import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by S N Rao on 4/5/2017.
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any
 * two time points in the list.
 *
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 *
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 *
 */
public class MinimumTimeDifferenceLeetCode {

    //There are 24*60=1440 minutes. Make a boolean array of 1440 and scan and find min difference.
    public static int findMinDifference(List<String> timePoints) {
        boolean[] minOfDay=new boolean[1440];
        for(String t:timePoints){
            String[] parts=t.split(":");
            int index=60*Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
            if(minOfDay[index]) return 0;   //same minute appears twice, min difference is 0.
            else minOfDay[index]=true;
        }

        int prev=Integer.MIN_VALUE, minDiff=Integer.MAX_VALUE, first=-1;
        for(int i=0;i<minOfDay.length;i++){
            if(minOfDay[i]){
                if(prev==Integer.MIN_VALUE) first=i;
                else minDiff=Math.min(minDiff,i-prev);
                prev=i;
            }
        }
        minDiff=Math.min(minDiff,1440-(prev-first));
        return minDiff;
    }

    public static void main(String args[]){
        List<String> list=new ArrayList<>(Arrays.asList("23:59","00:00"));
        System.out.print(findMinDifference(list));
    }
}
