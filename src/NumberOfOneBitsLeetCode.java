/**
 * Created by S N Rao on 4/10/2017.
 *
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the
 * Hamming weight).
 *
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function
 * should return 3.
 *
 */
public class NumberOfOneBitsLeetCode {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int mask=1,res=0;
        for(int i=0;i<32;i++){
            res+=((mask&n>>i)==1)?1:0;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(hammingWeight(11));
    }
}
