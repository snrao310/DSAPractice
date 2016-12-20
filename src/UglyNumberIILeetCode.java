/**
 * Created by snrao on 12/20/16.
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example,
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberIILeetCode {

    //O(n) algorithm. Maintain pointers for each prime number in the ugly array. Select minimum of element in
    //pointer location into the prime number associated with the pointer, make it the next element in ugly array
    //and increase the pointers of the prime whose multiple the new number is.
    public static int nthUglyNumber(int n) {
        int pointer2 = 0;
        int pointer3 = 0;
        int pointer5 = 0;
        int ugly[] = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            int min=Math.min(ugly[pointer2] * 2, Math.min(ugly[pointer3] * 3, ugly[pointer5] * 5));
            if(min==ugly[pointer2]*2) pointer2++;
            if(min==ugly[pointer3]*3) pointer3++;
            if(min==ugly[pointer5]*5) pointer5++;
            ugly[i]=min;
        }
        return ugly[n-1];
    }

    public static void main(String args[]) {
        System.out.print(nthUglyNumber(10));
    }
}
