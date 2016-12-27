/**
 * Created by snrao on 12/26/16.
 *
 * Implement pow(x, n).
 *
 */
public class PowLeetCode {

    public static double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==Integer.MIN_VALUE){
            x=1/x;
            n++; n=-n;      //changing n from even<->odd. so if x was negative, we need to change its sign also.
            if(x<0)
                x=-x;
        }
        else if(n<0){
            x=1/x;
            n=-n;
        }

        if(n%2==0) return myPow(x*x,n/2);
        else return x*myPow(x,n-1);
    }

    public static void main(String args[]){
        System.out.println(myPow(-1,-2147483648));
    }
}
