import java.util.HashMap;

/**
 * Created by S N Rao on 3/7/2017.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequences:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 *
 * The following sequence is not arithmetic.
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of
 * integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
 *
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence
 * A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.
 *
 * The function should return the number of arithmetic subsequence slices in the array A.
 *
 * The input contains N integers. Every integer is in the range of -2^31 and 2^31-1 and 0 ≤ N ≤ 1000. The output is
 * guaranteed to be less than 2^31-1.
 *
 * Example:
 * Input: [2, 4, 6, 8, 10]
 * Output: 7
 *
 * Explanation:
 * All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 *
 */
public class ArithmeticSlicesIISubsequenceLeetCode {


    // The ith element of HashMap array stores T(i, d)s with different d as keys. d is difference of APs.
    // T(i,d) denotes the total number of arithmetic subsequence slices ending at index i with difference d.
    // The base case and recurrence relation are as follows:
    //
    // Base case: T(0, d) = 0 (This is true for any d).
    // Recurrence relation: T(i, d) = summation of (1 + T(j, d)) as long as 0 <= j < i && d == A[i] - A[j].
    // For the recurrence relation, it's straightforward to understand the T(j, d) part: for each slice ending at index
    // j with difference d == A[i] - A[j], adding A[i] to the end of the slice will make a new arithmetic subsequence
    // slice, therefore the total number of such new slices will be the same as T(j, d). What you are probably wondering
    // is: where does the 1 come from?
    //
    // The point here is that to make our recurrence relation work properly, the meaning of arithmetic subsequence slice
    // has to be extended to include slices with only two elements (of course we will make sure these "phony" slices
    // won't contribute to our final count). This is because for each slice, we are adding A[i] to its end to form a new
    // one. If the original slice is of length two, after adding we will have a valid arithmetic subsequence slice with
    // three elements. Our T(i, d) will include all these "generalized" slices. And for each pair of elements (A[j],
    // A[i]), they will form one such "generalized" slice (with only two elements) and thus contribute to one count of
    // T(i, d).
    //
    public static int numberOfArithmeticSlices(int[] A) {
        HashMap<Integer,Integer>[] diffToSliceLen=new HashMap[A.length];
        int res=0;
        for(int i=0;i<A.length;i++){
            diffToSliceLen[i]=new HashMap<>();
            for(int j=0;j<i;j++){
                long d=A[i]-A[j];
                if(d>Integer.MAX_VALUE || d<=Integer.MIN_VALUE) continue;
                int diff=(int)d;
                int c1=diffToSliceLen[i].getOrDefault(diff,0);
                int c2=diffToSliceLen[j].getOrDefault(diff,0);
                res+=c2;    //counting till previous, since this one will have generalized slices (2 elements) also.
                diffToSliceLen[i].put(A[i]-A[j],c1+c2+1);   // +1 for two element slice. Not counted in res. Counted
                                                            // in next iteration when it becomes 3 elements.
            }
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(numberOfArithmeticSlices(new int[]{2, 2,3,4}));
    }
}
