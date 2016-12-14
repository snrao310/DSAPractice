import java.util.HashMap;

/**
 * Created by snrao on 12/13/16.
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that
 * A[i] + B[j] + C[k] + D[l] is zero.
 */

public class FourSumIILeetCode {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int sum=A[i]+B[j];
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        //can also sort and use binary search here but since the algorithm is anyway O(n^2),
        // can just go ahead with it.
        result=0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                int sum=(C[i]+D[j]);
                if(map.containsKey(0-sum))
                    result+=map.get(0-sum);
            }
        }

        return result;
    }

    public static void main(String args[]){
        int[] A = {1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};
        System.out.print(fourSumCount(A,B,C,D));
    }

}
