import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by snrao on 12/29/16.
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second
 * array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 */
public class FindKPairsWithSmallestSumLeetCode {

    //using heap. Two pointers will not work.
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result=new ArrayList<>();
        if(nums1.length==0 || nums2.length==0) return result;
        PriorityQueue<int[]> heap=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]+o1[1]>o2[0]+o2[1])
                    return 1;
                else if(o1[0]+o1[1]<o2[0]+o2[1])
                    return -1;
                return 0;
            }
        });

        for(int i=0;i<k && i<nums1.length;i++)
            heap.offer(new int[]{nums1[i],nums2[0],0});

        int count=0;
        while(count<k && !heap.isEmpty()){
            int[] popped=heap.poll();
            result.add(new int[]{popped[0],popped[1]});
            if(popped[2]==nums2.length-1){
                count++;
                continue;
            }
            heap.offer(new int[]{popped[0],nums2[popped[2]+1],popped[2]+1});
            count++;
        }
        return result;
    }

    public static void main(String args[]){
        List<int[]> list=kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3);
        for(int[] a:list){
            System.out.println(a[0]+" "+a[1]);
        }
    }
}
