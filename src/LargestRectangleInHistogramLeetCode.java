import java.util.Arrays;
import java.util.Stack;

/**
 * Created by S N Rao on 3/6/2017.
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 *
 */
public class LargestRectangleInHistogramLeetCode {

    public static int largestRectangleArea(int[] heights) {
        int len=heights.length;
        if(len==0) return 0;
        int[] lefts=new int[len], rights=new int[len];
        Arrays.fill(lefts,0); Arrays.fill(rights,len-1);
        Stack<Integer> stack=new Stack();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i])
                rights[stack.pop()]=i-1;
            stack.push(i);
        }
        stack.clear();
        for(int i=len-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i])
                lefts[stack.pop()]=i+1;
            stack.push(i);
        }

        int result=0;
        for(int i=0;i<len;i++){
            result=Math.max(result, (rights[i]-lefts[i]+1) * heights[i]);
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
