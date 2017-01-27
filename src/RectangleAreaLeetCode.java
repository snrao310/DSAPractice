/**
 * Created by S N Rao on 1/27/2017.
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 */
public class RectangleAreaLeetCode {

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1=area(A,B,C,D);
        int area2=area(E,F,G,H);

        //No overlap
        if(E>=C || A>=G) return area1+area2;
        if(B>=H || F>=D) return area1+area2;

        //Overlap area
        int a,b,c,d;
        a=Math.max(A, E);
        b=Math.max(B, F);
        c=Math.min(C, G);
        d=Math.min(D, H);

        int area3=area(a,b,c,d);
        int total= -area3 + area1 +area2; //subtracting first to avoid overflow
        return total;
    }

    private static int area(int xbot,int ybot,int xtop,int ytop){
        return (xtop-xbot)*(ytop-ybot);
    }

    public static void main(String args[]){
        System.out.println(computeArea(-3,-3,3,3,-5,-5,0,-4));
    }
}
