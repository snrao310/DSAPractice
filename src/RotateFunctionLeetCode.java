/**
 * Created by S N Rao on 1/27/2017.
 *
 * Given an array of integers A and let n to be its length.
 *
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F
 * on A as follow:
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 *
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 *
 * Note:
 * n is guaranteed to be less than 10^5.
 *
 */
public class RotateFunctionLeetCode {

    public static int maxRotateFunction(int[] A) {
        int sum=0,B=0,len=A.length;
        for(int i=0;i<len;i++){
            B+=i*A[i];
            sum+=A[i];
        }
        int max=B;
        for(int i=0;i<len-1;i++){
            B=B-sum+len*A[i];
            max=Math.max(max,B);
        }
        return max;
    }

    public static void main(String args[]){
        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
    }
}
