import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 12/27/16.
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on
 * the row below.
 *
 */
public class TriangleLeetCode {

    // Reduced a 2d array DP solution to 1D array DP solution, since only previous value required for computation.
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0) return 0;
        int[] DP=new int[triangle.size()];
        int[] prevDP=new int[triangle.size()];
        prevDP[0]=triangle.get(0).get(0);
        int min=prevDP[0];
        for(int i=1;i<triangle.size();i++){
            min=Integer.MAX_VALUE;
            Arrays.fill(DP,Integer.MAX_VALUE);
            for(int j=0;j<i;j++){
                DP[j]=Math.min(DP[j],prevDP[j]+triangle.get(i).get(j));
                DP[j+1]=Math.min(DP[j+1],prevDP[j]+triangle.get(i).get(j+1));
                min=Math.min(Math.min(DP[j],DP[j+1]),min);
            }
            prevDP=DP.clone();
        }
        return min;
    }

    public static void main(String args[]){
        List<List<Integer>> l= Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(l));
    }
}
