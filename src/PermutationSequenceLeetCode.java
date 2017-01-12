import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 1/12/2017.
 *
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 *
 */
public class PermutationSequenceLeetCode {

    public static String getPermutation(int n, int k) {
        List<Integer> ordered=new ArrayList<>();
        String result="";
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial*=i;
            ordered.add(i);
        }

        for(int i=n;i>=1;i--){
            factorial/=i;
            int digit=ordered.remove((int)Math.ceil((double) k/factorial)-1);
            result+=Integer.toString(digit);
            k%=factorial;
            if(k==0) k=factorial;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.print(getPermutation(4,3));
    }
}
