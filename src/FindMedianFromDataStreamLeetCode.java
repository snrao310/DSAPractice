import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by S N Rao on 3/8/2017.
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 * For example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 */
public class FindMedianFromDataStreamLeetCode {

    //Two heaps method, with maxHeap storing first half and minHeap storing second half.
    public static class MedianFinder {
        int count, balance;
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap=new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer o1,Integer o2){
                    return o2-o1;
                }
            });
            minHeap=new PriorityQueue<>();
            balance=0; count=0;
        }

        public void addNum(int num) {
            if(count==0) {
                maxHeap.add(num);
                count++;
                balance++;
                return;
            }

            if(maxHeap.peek()<num){
                minHeap.add(num);
                balance--;
            }
            else{
                maxHeap.add(num);
                balance++;
            }
            count++;

            if(balance==-1){
                maxHeap.add(minHeap.poll());
                balance=1;
            }
            else if(balance==2){
                minHeap.add(maxHeap.poll());
                balance=0;
            }
        }

        public double findMedian() {
            if(balance==0)
                return (double)((minHeap.peek()+maxHeap.peek())/2.0);
            else
                return (double) maxHeap.peek();
        }
    }


    public static void main(String args[]){
        /**
         * Your MedianFinder object will be instantiated and called as such:
         * MedianFinder obj = new MedianFinder();
         * obj.addNum(num);
         * double param_2 = obj.findMedian();
         */
        MedianFinder obj=new MedianFinder();
        obj.addNum(2); obj.addNum(3); obj.addNum(4);
        System.out.print(obj.findMedian() +" ");
        obj.addNum(4); obj.addNum(6); obj.addNum(4);
        System.out.print(obj.findMedian());
    }
}
