import java.util.HashMap;

/**
 * Created by S N Rao on 3/30/2017.
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the
 * range [-10000, 10000] (inclusive).
 *
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * Output:
 * 2
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 */
public class NumberOfBoomerangsLeetCode {

    public static int numberOfBoomerangs(int[][] points) {
        int res=0;
        for(int i=0;i<points.length;i++){
            HashMap<Double,Integer> distToCount=new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                double distance=findDistance(points[i],points[j]);
                distToCount.put(distance,distToCount.getOrDefault(distance,0)+1);
            }
            for(double key:distToCount.keySet()){
                int count=distToCount.get(key);
                res+=(count*(count-1));
            }
        }
        return res;
    }

    private static double findDistance(int[] p, int[] q){
        int x=p[0]-q[0]; x*=x;
        int y=p[1]-q[1]; y*=y;
        return Math.sqrt(x+y);
    }

    public static void main(String args[]){
        int[][] arr=new int[][]{{0,0},{1,0},{2,0}};
        System.out.print(numberOfBoomerangs(arr));
    }
}
