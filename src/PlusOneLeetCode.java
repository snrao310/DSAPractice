import java.util.Arrays;

/**
 * Created by S N Rao on 4/11/2017.
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 */
public class PlusOneLeetCode {

    public static int[] plusOne(int[] digits) {
        int n=digits.length;
        int i=n-1;
        while(i>=0 && digits[i]==9)
            digits[i--]=0;
        if(i==-1){
            int[] newDigits=new int[n+1]; //Initialized to all zeroes by default
            newDigits[0]=1;
            return newDigits;
        }
        else {
            digits[i]++;
            return digits;
        }
    }

    public static void main(String args[]){
        System.out.print(Arrays.toString(plusOne(new int[]{9,9})));
    }
}
