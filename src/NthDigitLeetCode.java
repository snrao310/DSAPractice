/**
 * Created by S N Rao on 4/24/2017.
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 * Input:
 * 3
 * Output:
 * 3
 *
 * Example 2:
 * Input:
 * 11
 * Output:
 * 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 */
public class NthDigitLeetCode {

    public static int findNthDigit(int n) {
        //First fin the lower bound power of 10 from the number (exp), lower bound digit index for this exponent (digExp)
        //and the length (number of digits) of the number at index n.
        if(n<10) return n;
        int len=2;
        long exp=10,digExp=10,nextDigExp=190;
        while(nextDigExp < n){
            len++; digExp=nextDigExp; exp*=10;
            nextDigExp += (9*exp*len);
        }

        //then find the number at this index n and the digit index inside the number and return it.
        long digAhead=n-digExp;
        long numAhead=digAhead/len;
        long num=numAhead+exp;
        long digInNum=digAhead%len;
        long res=0;
        for(long i=0; i<len-digInNum; i++){
            res=num%10; num/=10;
        }
        return (int)res;
    }

    public static void main(String args[]){
        System.out.print(findNthDigit(2166));
    }
}
