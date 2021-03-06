/**
 * Created by S N Rao on 4/14/2017.
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k
 * coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 *
 */
public class ArrangingCoinsLeetCode {

    public static int arrangeCoins(int n) {
        int root=(int)(Math.sqrt(1+8.0*n)-1)/2;     //k*(k+1)/2=n => k^2+k-2n=0. Solve for k and return root.
        return root;
    }

    public static void main(String args[]){
        System.out.print(arrangeCoins(12)); //4
    }
}
