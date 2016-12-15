/**
 * Created by snrao on 10/29/16.
 *
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 */
public class ArithmaticSlicesLeetCode {

    //finds the all the subsequences that are APs with length at least 3.
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3)
            return 0;

        int res = 0;
        int diff = A[1] - A[0];
        int count = 1;
        int ndiff;

        for (int i = 2; i < A.length; i++) {
            ndiff = A[i] - A[i - 1];
            if (ndiff == diff)
                count++;
            else {
                if (count > 1) {
                    res += (count * (count - 1) / 2);
                }
                count = 1;
                diff = ndiff;
            }
        }
        if (count > 1) {
            res += (count * (count - 1) / 2);
        }
        return res;
    }


    public static void main(String args[]) {
        int A[] = {1, 2, 3, 4};
        int k = numberOfArithmeticSlices(A);
        System.out.print(k);
    }
}
