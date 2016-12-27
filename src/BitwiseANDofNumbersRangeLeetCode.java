/**
 * Created by snrao on 12/26/16.
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range,
 * inclusive.
 * For example, given the range [5, 7], you should return 4.
 *
 */
public class BitwiseANDofNumbersRangeLeetCode {

    //Awesome Bit Manipulation Question. Start from MSB. Till where are the two numbers same in their bits?
    //Till there, its just the same bits, from the first different bit (inclusive) onwards, its just zeroes.
    public static int rangeBitwiseAnd(int m, int n) {
        int result=0;
        for(int i=31;i>=0;i--){
            int mask=1<<i;
            int check=(mask&m)^(mask&n);
            if(check==0)
                result |= (mask&m);
            else{
                return result;
            }
        }
        return result;
    }


    public static void main(String args[]){
        System.out.println(rangeBitwiseAnd(12,18));
    }
}
