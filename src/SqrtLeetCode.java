/**
 * Created by S N Rao on 1/13/2017.
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 *
 */
public class SqrtLeetCode {
    public static int mySqrt(int x) {
        if(x==0 ||x==1) return 1;
        int low=1,high=Math.min(x/2,46340); //46340 is square root of Integer.MAX_VALUE
        while (low<=high){
            int mid=(low+high)/2;
            int square=mid*mid;
            if(square==x)
                return mid;
            else if(square>x)
                high=mid-1;
            else
                low=mid+1;
        }
        return high;
    }

    public static void main(String args[]){
        System.out.println(mySqrt(2147395599));
//        System.out.println(mySqrt(15));
    }
}
