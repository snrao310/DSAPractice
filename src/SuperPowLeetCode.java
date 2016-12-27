/**
 * Created by snrao on 12/26/16.
 *
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
 * given in the form of an array.
 */
public class SuperPowLeetCode {

    public static int superPow(int a, int[] b) {
        return superPow(a,b,b.length);
    }

    private static int myPowerFunction(int a, int p){
        int c=a%1337;
        int result=1;
        for(int i=0;i<p;i++){
            result*=c;
            result%=1337;
        }
        return result;
    }

    //f(a,1234567) = f(a, 1234560) * f(a, 7) % 1337 = f(f(a, 123456),10) * f(a,7)%1337
    private static int superPow(int a, int[] b, int end){
        if(end==0)
            return 1;
        int pow=myPowerFunction(superPow(a,b,end-1),10);
        pow*=myPowerFunction(a,b[end-1]);
        pow%=1337;
        return pow;
    }

    public static void main(String args[]) {
        System.out.println(superPow(2147483647, new int[]{2,0,0}));
    }
}
