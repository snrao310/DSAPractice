import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by S N Rao on 2/21/2017.
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So
 * the median is the mean of the two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very
 * right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your
 * job is to output the median array for each window in the original array.
 *
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 *
 * Note:
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 *
 */
public class SlidingWindowMedianLeetCode {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        //Edge case
        if(nums==null || nums.length==0 || k<=0) return null;

        //2 heaps. One stores first half with max value in root, the other stores second half with min value in root.
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();   //second half of sorted array
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder()); //first half of sorted array

        //basic values. balance is difference between actual (not counting out of window elements) heap sizes.
        //We always keep balance 0 or 1. Min heap is more always.
        int len=nums.length,balance,pointer=0;
        double median;
        double[] result=new double[len-(k-1)];

        //Hashmap to store deleted elements from heap. When the element reachees root we delete. If value of key x is 0,
        // it means the element is not deleted. If value is -k, it has been deleted k times ie k occurances of the element
        // in the heap are actually invalid (out of window).
        // This method avoids searching for element and deleting it when it goes out of window. Searching (remove()) in
        // heap is O(n).
        HashMap<Integer,Integer> count=new HashMap<>();

        //filling the heaps.
        for(int i=0;i<k;i++) {
            minHeap.offer(nums[i]);
            count.put(nums[i],0);
        }
        for(int i=0;i<k/2;i++)
            maxHeap.offer(minHeap.poll());

        //first value of result array filled.
        balance=minHeap.size()-maxHeap.size();
        median=(balance!=0)?minHeap.peek():(((double)minHeap.peek()+(double)maxHeap.peek())/2.0);
        result[pointer++]=median;

        //Looping through all elemnts.
        for(int i=k;i<len;i++){
            int newElement=nums[i]; //needs to be added to window
            int oldElement=nums[i-k]; //must remove from the window

            //removing the oldElement if its in the root of either heap.
            //Else decreasing its count so it can be deleted when it reaches root.
            if(oldElement>= minHeap.peek()){
                if(oldElement==minHeap.peek()) minHeap.poll();
                else count.put(oldElement,count.get(oldElement)-1);
                balance--;
            }
            else{
                if(oldElement==maxHeap.peek()) maxHeap.poll();
                else count.put(oldElement,count.get(oldElement)-1);
                balance++;
            }

            //Adding new element to the heap. Deciding which heap to add to is important.
            if(!minHeap.isEmpty() && newElement>=minHeap.peek()) {
                minHeap.offer(newElement);
                count.put(newElement,count.getOrDefault(newElement,0));
                balance++;
            }
            else if(!maxHeap.isEmpty() && newElement<=maxHeap.peek()) {
                maxHeap.offer(newElement);
                count.put(newElement,count.getOrDefault(newElement,0));
                balance--;
            }
            else{
                minHeap.offer(newElement);
                count.put(newElement,count.getOrDefault(newElement,0));
                balance++;
            }

            //removing any deleted elements from heap root since we need root to adjust balance between trees (next step)
            while(!minHeap.isEmpty() && count.get(minHeap.peek())<0){
                count.put(minHeap.peek(),count.get(minHeap.peek())+1);
                minHeap.poll();
            }
            while(!maxHeap.isEmpty() && count.get(maxHeap.peek())<0){
                count.put(maxHeap.peek(),count.get(maxHeap.peek())+1);
                maxHeap.poll();
            }

            //Balance between trees adjusted. Bringing the balance to permitted values of 0 or 1.
            if(balance>1) {
                maxHeap.offer(minHeap.poll());
                balance-=2;
            }
            else if(balance<0) {
                minHeap.offer(maxHeap.poll());
                balance += 2;
            }

            //removing any deleted elements from heap root again
            //Since the root may have changed after balancing and we need the root again for finding median (next step).
            while(!minHeap.isEmpty() && count.get(minHeap.peek())<0){
                count.put(minHeap.peek(),count.get(minHeap.peek())+1);
                minHeap.poll();
            }
            while(!maxHeap.isEmpty() && count.get(maxHeap.peek())<0){
                count.put(maxHeap.peek(),count.get(maxHeap.peek())+1);
                maxHeap.poll();
            }

            //Finding median and setting in result array.
            median=(balance!=0)?minHeap.peek():(((double)minHeap.peek()+(double)maxHeap.peek())/2.0);
            result[pointer++]=median;
        }
        return result;
    }

    public static void main(String args[]){
        double[] result=medianSlidingWindow(new int[]{2147483647,2147483647},2);
        for(double d: result)
            System.out.print(d+" ");
    }
}
