import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by S N Rao on 2/17/2017.
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum
 * is no larger than k.
 *
 * Example:
 * Given matrix = [
 * [1,  0, 1],
 * [0, -2, 3]
 * ]
 * k = 2
 * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
 *
 */
public class MaxSumOfRectangleNoLargerThanKLeetCode {

    //Very very non intuitive. Check explanation below to understand. Updated: Hardest problem till now.
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length==0) return 0;
        int result=Integer.MIN_VALUE, m=matrix.length, n=matrix[0].length;
        for(int l=0;l<n;l++){
            int[] sums=new int[m];
            for(int r=l;r<n;r++){
                for(int i=0;i<m;i++)
                    sums[i]+=matrix[i][r];

                TreeSet<Integer> set=new TreeSet<>();
                set.add(0);
                int curMax=Integer.MIN_VALUE, cum_j=0;
                for(int sum:sums){
                    cum_j+=sum;
                    Integer cum_i=set.ceiling(cum_j - k);
                    if(cum_i!=null)
                        curMax=Math.max(curMax, cum_j - cum_i);
                    set.add(cum_j);
                }
                result=Math.max(result, curMax);
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.print(maxSumSubmatrix(new int[][]{{2,  2, -1}},3));
    }
}


/***
 * The naive solution is brute-force, which is O((mn)^2). In order to be more efficient, I tried something similar to
 * Kadane's algorithm. The only difference is that here we have upper bound restriction K. Here's the easily understanding
 * video link for the problem "find the max sum rectangle in 2D array": https://www.youtube.com/watch?v=yCQN096CwWM (Maximum
 * Sum Rectangular Submatrix in Matrix dynamic programming/2D kadane) (Trust me, it's really easy and straightforward).
 *
 * Once you are clear how to solve the above problem, the next step is to find the max sum no more than K in an array.
 * his can be done within O(nlogn), and you can refer to this article: max subarray sum no more than k. (Below copy pasted from link)
 * https://www.quora.com/Given-an-array-of-integers-A-and-an-integer-k-find-a-subarray-that-contains-the-largest-sum-subject-to-a-constraint-that-the-sum-is-less-than-k
 *
 * For the solution below, I assume that the number of rows is larger than the number of columns. Thus in general time
 * complexity is O[min(m,n)^2 * max(m,n) * log(max(m,n))], space O(max(m, n)).
 */


/***
 * You can do this in O(nlog(n))
 *
 * First thing to note is that sum of subarray (i,j] is just the sum of the first j elements less the sum of the
 * first ii elements. Store these cumulative sums in the array cum. Then the problem reduces to finding  i,j such that
 * i<j and cum[j]−cum[i] is as close to k but lower than it.
 *
 * To solve this, scan from left to right. Put the cum[i] values that you have encountered till now into a set (TreeSet in java).
 * When you are processing cum[j] what you need to retrieve from the set is the smallest number in the set which
 * is bigger than cum[j]−k. This lookup can be done in O(logn) using upper_bound (ceiling in java). Hence the overall
 * complexity is O(nlog(n).
 *
 */