import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 3/6/2017.
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
public class PerfectRectangleLeetCode {

    //Can directly use the string as key, but I wanted to try this.
    private static class Vertex{
        int x; int y;
        String code;

        public Vertex(int x, int y){
            this.x=x; this.y=y;
            code=x+" "+y;
        }

        //These two functions will let you use object of this class as key in hashmap or element of hashset by actually
        // using its instance variable as its key.
        @Override
        public int hashCode() {
            return code.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode()==obj.hashCode();
        }
    }


    //The right answer must satisfy two conditions:
    //the large rectangle area should be equal to the sum of small rectangles
    //count of all the points should be even, and that of all the four corner points should be one
    public static boolean isRectangleCover(int[][] rectangles) {
        HashSet<Vertex> vertices=new HashSet<>();
        int totalArea=0, minX=Integer.MAX_VALUE, minY=Integer.MAX_VALUE, maxX=Integer.MIN_VALUE, maxY=Integer.MIN_VALUE;
        for(int[] rectangle: rectangles){
            Vertex[] fourVertices=new Vertex[4];
            minX=Math.min(minX,rectangle[0]);
            minY=Math.min(minY,rectangle[1]);
            maxX=Math.max(maxX,rectangle[2]);
            maxY=Math.max(maxY,rectangle[3]);
            fourVertices[0]=new Vertex(rectangle[0], rectangle[1]);
            fourVertices[1]=new Vertex(rectangle[0], rectangle[3]);
            fourVertices[2]=new Vertex(rectangle[2], rectangle[1]);
            fourVertices[3]=new Vertex(rectangle[2], rectangle[3]);

            for(Vertex v:fourVertices){
                if(vertices.contains(v)) vertices.remove(v);
                else vertices.add(v);
            }

            totalArea+=((rectangle[2]-rectangle[0])*(rectangle[3]-rectangle[1]));
        }

        if(vertices.size()!=4) return false;
        if(!vertices.contains(new Vertex(minX,minY)) || !vertices.contains(new Vertex(minX,maxY)) ||
                !vertices.contains(new Vertex(maxX,minY)) || !vertices.contains(new Vertex(maxX,maxY)))
            return false;
        if(totalArea!=((maxX-minX)*(maxY-minY))) return false;

        return true;
    }

    public static void main(String args[]){
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2}, {1,3,2,4}, {2,2,4,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2}, {1,3,2,4}, {3,2,4,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2}, {3,2,4,4}, {1,3,2,4}, {2,3,3,4}}));
    }
}
