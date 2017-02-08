/**
 * Created by S N Rao on 2/7/2017.
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 *  Note:
 *  0 ≤ x, y < 2^31.
 *
 */
public class HammingDistanceLeetCode {

    public static int hammingDistance(int x, int y) {
        int result=0,mask=1;
        for(int i=0;i<32;i++){
            if((mask&x)!=(mask&y)) result++;
            mask <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

}
