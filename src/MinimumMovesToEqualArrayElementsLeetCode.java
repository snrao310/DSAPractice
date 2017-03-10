/**
 * Created by S N Rao on 3/10/2017.
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 */
public class MinimumMovesToEqualArrayElementsLeetCode {

    // This is an awesome tricky short question. The key is:
    // Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in
    // the array equal.
    // So, best way to do this question is find min steps (reducing 1 max element by 1 each time) to
    // make all the elements in the array equal to the min element.
    //
    public static int minMoves(int[] nums) {
        if(nums.length==0) return 0;
        int res=0, len=nums.length,min=Integer.MAX_VALUE;
        for(int i:nums) min=Math.min(min,i);
        for(int i:nums) res+=i-min;
        return res;
    }

    public static void main(String args[]){
        System.out.print(minMoves(new int[]{1,2,3}));
    }
}
