/**
 * Created by S N Rao on 4/24/2017.
 *
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192
 * (represented in binary as 00111001011110000010100101000000).
 *
 */
public class ReverseBitsLeetCode {

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res=0,mask=1;
        for(int i=0;i<32;i++){
            res <<=1; res |= (mask&n);
            n >>>=1;    //unisigned shift
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(reverseBits(4)); //536870912
    }
}
