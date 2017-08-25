/**
 * Created by S N Rao on 8/23/2017.
 *
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 */
public class DivideTwoIntegersLeetCode2 {

    public static int divide(int dividend, int divisor) {
        boolean negative=false;
        if(divisor==0) return Integer.MAX_VALUE;
        if(dividend==0) return 0;
        if(divisor==1) return dividend;

        if(dividend<0 && divisor>0) negative=true;
        if(dividend>0 && divisor<0) negative=true;
        long divid=Math.abs((long) dividend);
        long divis=Math.abs((long) divisor);
        long res=0;
        while(divid>=divis){
            int multiple=1; long div=divis;
            while(divid > (div<<1)){
                div<<=1;
                multiple<<=1;
            }
            res+=multiple;
            divid-=div;
        }
        if(negative) res*=-1;
        if(res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) res;
    }

    public static void main(String args[]){
        System.out.print(divide(-1,1));
    }
}
