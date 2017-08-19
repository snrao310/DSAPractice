package Done;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by S N Rao on 3/31/2017.
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 */
public class MaxPointsOnALineLeetCode {

    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    //For each point:
    //          go through all other points and find slope of line connecting them. All the points with same slopes will
    //          be on the same line. So maintain a HashMap from slope to number of points. (Also check cases for
    //          duplicate points and points with same x value carefully).
    //Return maximum count among all slopes in all iterations.


    //This method uses BigDecimal to store slopes. Can also use a self defined pair as shown in next function.
    public static int maxPoints(Point[] points) {
        if(points.length==0) return points.length;
        int globalMax=1;
        Double INFINITY= Double.MAX_VALUE;
        for(Point p:points){
            int samePoint=0, maxVal=1;

            //Using BigDecimal because precision of Double was not enough to differentiate slopes correctly.
            BigDecimal slope=new BigDecimal(0);
            HashMap<BigDecimal,Integer> slopeToNumPoints=new HashMap<>();

            for(Point q:points){
                if(p==q) continue;

                //Duplicate Point
                if(p.x==q.x && p.y==q.y){
                    samePoint++; continue;
                }

                //Slope is Infinity
                else if(p.x==q.x)
                    slope=new BigDecimal(INFINITY);

                    //Find slope and increase count of points on the line.
                else
                    slope=new BigDecimal((p.y-q.y)).divide(new BigDecimal((p.x-q.x)),16, BigDecimal.ROUND_HALF_UP);

                slopeToNumPoints.put(slope,slopeToNumPoints.getOrDefault(slope,1)+1);
                maxVal=Math.max(maxVal,slopeToNumPoints.get(slope));
            }
            maxVal+=samePoint;
            globalMax=Math.max(globalMax,maxVal);
        }
        return globalMax;
    }



    //This method defines a Pair class to store slope. Slope(y/x) is converted to lowest form by dividing by gcd of
    //y and x and these two values are used to define and access the pair.
    private static class Pair{
        int xDiff;
        int yDiff;
        String code;
        Pair(int x,int y){xDiff=x;yDiff=y;code=x+" "+y;}

        @Override
        public int hashCode(){
            return code.hashCode();
        }

        @Override
        public boolean equals(Object o){
            return o.hashCode()==this.hashCode();
        }
    }

    private static int gcd(int x,int y){
        x=Math.abs(x); y=Math.abs(y);
        int a=Math.max(x,y), b=Math.min(x,y);
        while(b>0){
            int rem=a%b;
            a=b; b=rem;
        }
        return a;
    }

    public static int maxPointsPair(Point[] points) {
        if(points.length==0) return points.length;
        int globalMax=1;

        for(Point p:points){
            int samePoint=0, maxVal=1;

            Pair slope;
            HashMap<Pair,Integer> slopeToNumPoints=new HashMap<>();

            for(Point q:points){
                if(p==q) continue;

                //Duplicate Point
                if(p.x==q.x && p.y==q.y){
                    samePoint++; continue;
                }

                //Slope is Infinity
                else if(p.x==q.x)
                    slope=new Pair(0,Integer.MAX_VALUE);

                //Find slope and increase count of points on the line.
                else {
                    int gcd=gcd(p.y-q.y, p.x-q.x);
                    if(gcd==0) {slope=new Pair(0,0);}
                    else {
                        int xDiff=(p.x-q.x)/gcd, yDiff=(p.y-q.y)/gcd;
                        slope = new Pair(xDiff,yDiff);
                    }
                }

                slopeToNumPoints.put(slope,slopeToNumPoints.getOrDefault(slope,1)+1);
                maxVal=Math.max(maxVal,slopeToNumPoints.get(slope));
            }
            maxVal+=samePoint;
            globalMax=Math.max(globalMax,maxVal);
        }
        return globalMax;
    }

    public static void main(String args[]){
//        Point[] points={new Point(0,0), new Point(1,1), new Point(1,1),new Point(2,2),new Point(3,3),new Point(1,2),new Point(2,3)}; //must print 5
        Point[] points={new Point(0,0), new Point(94911151,94911150), new Point(94911152,94911151)}; //must print 2
        System.out.print(maxPointsPair(points));
    }
}
