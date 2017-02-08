/**
 * Created by S N Rao on 2/8/2017.
 *
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 */
public class NumberComplementLeetCode {

    public static int findComplement(int num) {
        int mask=1<<30;
        if((mask&num)!=0) return Integer.MAX_VALUE ^ num;
        while(((mask>>1)&num)==0)
            mask >>= 1;
        mask-=1;
        return mask^num;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

}