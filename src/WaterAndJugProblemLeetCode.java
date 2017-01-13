/**
 * Created by S N Rao on 1/13/2017.
 *
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 *
 * Operations allowed:
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 *
 *
 */
public class WaterAndJugProblemLeetCode {

    public static boolean canMeasureWater(int x, int y, int z) {
        if(z> x+y) return false;
        if(z==0 || x==z ||y==z) return true;
        return z%GCD(x,y)==0;  //xa+yb=z, is there such an a and b? Thats the question. If z is a multiple of gcd of
                                // x and y, then we can express x,y,and z as multiples of gcd and we can definitely find
                                // integers a and b that will satisfy the equation.
    }

    private static int GCD(int x,int y){
        int k=y;
        while(k!=0){
            k=x%y;
            x=y;
            y=k;
        }
        return x;
    }

    public static void main(String args[]){
        System.out.println(canMeasureWater(5,3,4));
        System.out.println(canMeasureWater(2,6,5));
    }
}
