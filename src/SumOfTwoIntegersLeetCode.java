/**
 * Created by S N Rao on 2/20/2017.
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 */
public class SumOfTwoIntegersLeetCode {

    public static int getSum(int a, int b) {
        int mask=1, carry=0, res=0;
        for(int i=0;i<32;i++){
            int aa=a&mask;
            int bb=b&mask;
            res |= ((aa^bb)^carry);
            if((aa&bb)!=0 ||(aa&carry)!=0 || (bb&carry)!=0)
                carry=mask<<1;
            else
                carry=0;
            mask <<= 1;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(getSum(56,20));
    }
}
