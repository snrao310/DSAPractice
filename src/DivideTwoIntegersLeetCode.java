/**
 * Created by S N Rao on 1/25/2017.
 *
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 */
public class DivideTwoIntegersLeetCode {

    public static int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(divisor==1) return dividend;
        int sign=((dividend<0)?-1:1)*((divisor<0)?-1:1);
        long divis=Math.abs((long)divisor);
        long divid=Math.abs((long)dividend);
        int result=0;
        while(divid>=divis){
            long div=divis,multiple=1;
            while(divid >= (div<<1)){
                div<<=1;
                multiple<<=1;
            }
            divid-=div;
            result+=multiple;
        }
        return result*sign;
    }

    public static void main(String args[]){
        System.out.print(divide(-2147483648,2));
    }
}
