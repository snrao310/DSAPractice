import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by S N Rao on 8/17/2017.
 *
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 *
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented
 * as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 *
 * Example 1:
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]
 * ]
 * Return true. All 5 rectangles together form an exact cover of a rectangular region.
 *
 * Example 2:
 * rectangles = [
 * [1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]
 * ]
 * Return false. Because there is a gap between the two rectangular regions.
 *
 * Example 3:
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]
 * ]
 * Return false. Because there is a gap in the top center.
 *
 * Example 4:
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]
 * ]
 * Return false. Because two of the rectangles overlap with each other.
 *
 */
public class PerfectRectangleLeetCode2 {

    public static class Vertex{
        int x,y;
        String code="";
        public Vertex(int x,int y){
            this.x=x; this.y=y; code=x+" "+y;
        }

        @Override
        public int hashCode(){
            return this.code.hashCode();
        }

        public boolean equals(Object obj){
            return obj.hashCode()==this.hashCode();
        }

    }

    private static int area(Vertex a, Vertex b){
        return Math.abs(a.x-b.x)*Math.abs(a.y-b.y);
    }

    public static boolean isRectangleCover(int[][] rectangles) {
        HashMap<Vertex,Integer> count=new HashMap<>();
        int areaSum=0,minX=Integer.MAX_VALUE,minY=Integer.MAX_VALUE,maxX=Integer.MIN_VALUE,maxY=Integer.MIN_VALUE;
        for(int[] rect:rectangles){
            Vertex point1=new Vertex(rect[0],rect[1]);
            Vertex point2=new Vertex(rect[2],rect[3]);
            Vertex point3=new Vertex(rect[0],rect[3]);
            Vertex point4=new Vertex(rect[2],rect[1]);
            minX=Math.min(minX,point1.x);
            minY=Math.min(minY,point1.y);
            maxX=Math.max(maxX,point2.x);
            maxY=Math.max(maxY,point2.y);
            count.put(point1,count.getOrDefault(point1,0)+1);
            count.put(point2,count.getOrDefault(point2,0)+1);
            count.put(point3,count.getOrDefault(point3,0)+1);
            count.put(point4,count.getOrDefault(point4,0)+1);
            areaSum+=area(point1, point2);
        }
        if(areaSum!=area(new Vertex(minX,minY),new Vertex(maxX,maxY))) return false;
        HashSet<Vertex> keySet=new HashSet<>(count.keySet());
        for(Vertex v:keySet){
            if(count.get(v)%2==0)
                count.remove(v);
        }
        if(count.size()!=4) return false;
        if(!count.containsKey(new Vertex(minX,minY)) || !count.containsKey(new Vertex(minX,maxY)) || !count.containsKey(new Vertex(maxX,minY)) || !count.containsKey(new Vertex(maxX,maxY)))
            return false;
        return true;
    }

    public static void main(String args[]){
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2}, {1,3,2,4}, {2,2,4,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2}, {1,3,2,4}, {3,2,4,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2}, {3,2,4,4}, {1,3,2,4}, {2,3,3,4}}));
    }
}
