import java.util.*;

/**
 * Created by S N Rao on 2/3/2017.
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElementsLeetCode {

    public static class HeapObj{
        int num;
        int freq;
        HeapObj(int num){this.num=num; freq=0;}
    }

    //O(nlogk) time
    public static List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<HeapObj> heap=new PriorityQueue<>(new Comparator<HeapObj>(){
            @Override
            public int compare(HeapObj o1,HeapObj o2){
                if(o1.freq>o2.freq) return 1;
                if(o1.freq<o2.freq) return -1;
                return 0;
            }
        });
        HashMap<Integer,HeapObj> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            HeapObj obj=(map.containsKey(nums[i]))?map.get(nums[i]):new HeapObj(nums[i]);
            map.put(nums[i],obj);
            heap.remove(obj);
            obj.freq++;
            heap.add(obj);
            if(heap.size()>k)
                heap.poll();
        }

        List<Integer> result=new ArrayList<>();
        while(!heap.isEmpty())
            result.add(heap.poll().num);

        return result;
    }


    //O(n) time, coz List is actually an arraylist, so average time to add is o(1).
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer>[] freqToNums=new List[nums.length+1];
        HashMap<Integer,Integer> numsToFreq=new HashMap<>();

        for(int i=0;i<nums.length;i++)
            numsToFreq.put(nums[i],numsToFreq.getOrDefault(nums[i],0)+1);

        for(int i:numsToFreq.keySet()){
            if(freqToNums[numsToFreq.get(i)]==null)
                freqToNums[numsToFreq.get(i)]=new ArrayList<>();
            freqToNums[numsToFreq.get(i)].add(i);
        }

        List<Integer> result=new ArrayList<>();
        int size=0;
        for(int i=freqToNums.length-1;i>=0;i--){
            if(freqToNums[i]!=null) {
                result.addAll(freqToNums[i]);
                if(result.size()>k) break;
            }
        }
        return result.subList(0,k);
     }

    public static void main(String args[]){
        List<Integer> list=topKFrequent2(new int[]{4,1,-1,2,-1,2,3},2);
        for(int i:list) System.out.print(i+" ");
    }
}
