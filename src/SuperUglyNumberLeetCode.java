import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by snrao on 12/20/16.
 *
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size
 * k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly
 * numbers given primes = [2, 7, 13, 19] of size 4.
 *
 */
public class SuperUglyNumberLeetCode {

    //same method as ugly number II, which had complexity O(n) because k was constant 3.
    // Here the complexity is O(nk), coz k is variable and we maintain an array called pointers instead of 3
    //variables we maintained in the case of ugly number II. A better method with heap exists. Also
    // implemented here
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int pointers[]=new int[primes.length];
        int ugly[]=new int[n];
        Arrays.fill(pointers,0);
        ugly[0]=1;

        for(int i=1;i<n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                if(ugly[pointers[j]]*primes[j] <min)
                    min=ugly[pointers[j]]*primes[j];
            }

            for(int j=0;j<primes.length;j++){
                if(min==primes[j])
                    pointers[j]=i;  //avoiding duplicates
                else if(min==ugly[pointers[j]]*primes[j])
                    pointers[j]++;
            }

            ugly[i]=min;
        }
        return ugly[n-1];
    }

    //Heap method. Gives a complexity of O(nlogk). Same logic as previous method but instead of O(k), loop
    //to compute min every time, use heap.
    public static int nthSuperUglyNumber_heap(int n, int[] primes) {
        int ugly[]=new int[n];
        ugly[0]=1;

        PriorityQueue<HeapElement> heap=new PriorityQueue<>(new Comparator<HeapElement>() {
            @Override
            public int compare(HeapElement o1, HeapElement o2) {
                if(o1.val>o2.val)
                    return 1;
                if(o1.val<o2.val)
                    return -1;
                return 0;
            }
        });

        for(int i=0;i<primes.length;i++)
            heap.add(new HeapElement(primes[i],primes[i],0));

        for(int i=1;i<n;i++){
            int min=heap.peek().val;
            ugly[i]=min;
            while(heap.peek().val==min){
                HeapElement minEl = heap.poll();
                heap.add(new HeapElement(minEl.primeFactor * ugly[minEl.pointer + 1], minEl.primeFactor, minEl.pointer + 1));
            }
        }
        return ugly[n-1];
    }

    public static class HeapElement{
        int val;
        int primeFactor;
        int pointer;

        public HeapElement(int val, int primeFactor, int pointer){
            this.val=val;
            this.primeFactor=primeFactor;
            this.pointer=pointer;
        }
    }

    public static void main(String args[]){
        System.out.print(nthSuperUglyNumber(12,new int[]{2, 7, 13, 19}));
    }
}
