import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.function.ObjDoubleConsumer;

/**
 * Created by S N Rao on 8/18/2017.
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 */
public class MaxPointsOnALineLeetCode2 {

    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public static class Pair {
        int x, y;
        String code;
        Pair(int a, int b){y=a;x=b;code=y+" "+x;}
        @Override
        public int hashCode(){return code.hashCode();}
        @Override
        public boolean equals(Object obj){return obj.hashCode()==this.hashCode();}
    }

    public static int gcd(int a, int b){
        a=Math.abs(a); b=Math.abs(b);
        if(b>a){
            int temp=b;
            b=a; a=temp;
        }
        int r=a%b;
        while(r>0){
            a=b; b=r;
            r=a%b;
        }
        return b;
    }


    public static int maxPoints(Point[] points) {
        if(points.length==0) return 0;
        int globalMax=1;

        for(Point p:points){
            HashMap<Pair,Integer> slopeMap=new HashMap<Pair, Integer>();
            int samePoint=0,maxPoints=1;
            Pair slope;
            for(Point q:points){
                if(p==q) continue;

                if(p.x==q.x && p.y==q.y) {
                    samePoint++;
                    continue;
                }

                else if(p.x==q.x)
                    slope=new Pair(0,0);


                else if(p.y==q.y)
                    slope=new Pair(0,Integer.MAX_VALUE);

                else{
                    int div=gcd(p.x-q.x,p.y-q.y);
                    int x=(p.x-q.x)/div, y=(p.y-q.y)/div;
                    slope=new Pair(y,x);
                }
                slopeMap.put(slope,slopeMap.getOrDefault(slope,0)+1);
                maxPoints=Math.max(maxPoints,slopeMap.get(slope)+1);
            }
            globalMax=Math.max(globalMax,maxPoints+samePoint);
        }
        return globalMax;
    }


    public static void main(String args[]){
        Point[] points={new Point(-4,-4), new Point(-8,-582), new Point(-3,3),new Point(-9,-651),new Point(9,591)};//,new Point(2,2),new Point(3,3),new Point(1,2),new Point(2,3)}; //must print 5
//        Point[] points={new Point(0,0), new Point(94911151,94911150), new Point(94911152,94911151)}; //must print 2
        System.out.print(maxPoints(points));
    }
}
