/**
 * Created by S N Rao on 3/8/2017.
 *
 *
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then
 * x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move
 * your direction changes counter-clockwise.
 *
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 *
 * Example 1:
 * Given x =
 * [2, 1, 1, 2]
 *  ┌───┐
 *  │    │
 *  └───┼──>
 *       │
 * Return true (self crossing)
 *
 * Example 2:
 * Given x =
 * [1, 2, 3, 4]
 * ┌──────┐
 * │        │
 * │
 * │
 * └────────────>
 * Return false (not self crossing)
 *
 * Example 3:
 * Given x =
 * [1, 1, 1, 1]
 * ┌───┐
 * │    │
 * └───┼>
 * Return true (self crossing)
 *
 */
public class SelfCrossingLeetCode {

    // Categorize the self-crossing scenarios, there are 3 of them:
    // 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
    // 2. Fifth line meets first line and works for the lines after
    // 3. Sixth line crosses first line and works for the lines after
    // For each line i, check i+3 overlap, i+4 overlap, and i+5 overlap.
    public static boolean isSelfCrossing(int[] x) {
        int len=x.length;
        for(int i=0;i<len;i++){
            //i+3 overlap.
            if(i+3<len && (x[i]-x[i+2]>=0 && x[i+1]-x[i+3]<=0))
                return true;
            //i+4 overlap
            if(i+4<len && (x[i+1]-x[i+3]==0 && x[i+2]<=x[i+4]+x[i]))
                return true;
            //i+5 overlap
            if(i+5<len && (x[i]<=x[i+2] && x[i]-x[i+2]+x[i+4]<=x[i] && x[i]-x[i+2]+x[i+4]>=0) &&
                    (x[i+1]<=x[i+3] && x[i+1]-x[i+3]+x[i+5]<=x[i+1] && x[i+1]-x[i+3]+x[i+5]>=0))
                return true;

        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(isSelfCrossing(new int[]{1,1,1,1}));
    }
}
