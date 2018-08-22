import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by S N Rao on 2/20/2017.
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7]
 *
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 *
 */
public class SlidingWindowMaximumLeetCode {

    //One straightforward method is to use a heap of k elements and always pick max from it for each window and delete
    //one element (the one that is kicked out of window) each time. Both are logn operations and whole thing will take
    //O(nlogn) time.
    //
    //But the question asks for O(n). Key observation is that all elements in the window are not needed
    //to find max in the window. Redundant elements can be removed. Also, a double-ended queue or DEqueue is a suitable
    //choice for this question. For complexity analysis, think of it this way: Each element is put and polled from the
    //queue once.
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0 || k==1) return nums;
        if(k<1) return null;

        Deque<Integer> queue=new LinkedList<>();    //queue of indices. Helps push off redundant elements and maintain head at window's max.
        int j=0;
        int[] result=new int[nums.length-(k-1)];
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && queue.peekFirst()<=i-k)
                queue.pollFirst();

            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i])
                queue.pollLast();

            queue.offer(i);
            if(i>= k-1)
                result[j++]=nums[queue.peekFirst()];
        }
        return result;
    }

    public static void main(String args[]){
        int[] result=maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for(int i: result)
            System.out.print(i+" ");
    }
}
