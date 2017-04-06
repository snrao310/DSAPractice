import java.util.HashSet;

/**
 * Created by S N Rao on 4/6/2017.
 *
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these
 * N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:
 *
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation:
 * The first beautiful arrangement is [1, 2]:
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * The second beautiful arrangement is [2, 1]:
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *
 * Note:
 * N is a positive integer and will not exceed 15.
 *
 */
public class BeautifulArrangementLeetCode {

    //Straightforward backtracking.
    static int count;
    public static int countArrangement(int N) {
        count=0;
        backTrackFunction(0,new HashSet<Integer>(),N);
        return count;
    }

    private static void backTrackFunction(int pos,HashSet<Integer> set,int N){
        for(int i=1;i<=N;i++){
            if(!set.contains(i) && (i%(pos+1)==0 || (pos+1)%i==0)){
                set.add(i);
                if(pos==N-1) count++;
                else backTrackFunction(pos+1,set,N);
                set.remove(i);
            }
        }
    }

    public static void main(String args[]){
        System.out.print(countArrangement(2));
    }
}
