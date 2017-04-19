/**
 * Created by S N Rao on 4/18/2017.
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 */
public class FactorialTrailingZeroesLeetCode {

    //Everytime there is a 5,2 factor pair there is a trailing 0. 2s are abundant, so it depends on how many 5s are there
    //in the factors of all numbers in n!.
    public static int trailingZeroes(int n) {
        long numFives=0, fiveMultiple=5;
        while(fiveMultiple<=n){
            numFives+=n/fiveMultiple;
            fiveMultiple*=5;
        }
        return (int)numFives;
    }

    public static void main(String args[]){
        System.out.print(trailingZeroes(50));
    }
}
