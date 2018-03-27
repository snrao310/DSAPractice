package Done;

/**
 * Created by S N Rao on 2/6/2017.
 *
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 */
public class MinimumMovesToEqualArrayElementsIILeetCode {

    //Median is the value that every element will reaach after increments/ decrements.
    //Find median using quickselect and get difference from median to each element.
    public static int minMoves2(int[] nums) {
        int median=getMedian(nums,nums.length/2,0,nums.length-1);
        int result=0;
        for(int i=0;i<nums.length;i++){
            result+=Math.abs(median-nums[i]);
        }
        return result;
    }

    private static int getMedian(int[] nums,int k, int start,int end){
        int randInd=(int) (Math.random()*(end-start+1));
        int pivotInd=start+randInd;
        swap(nums,pivotInd,start);
        pivotInd=partitionAroundPivot(nums,start,end);
        if(pivotInd==start+k) return nums[pivotInd];
        if(pivotInd>start+k) return getMedian(nums,k,start,pivotInd-1);
        else return getMedian(nums,k-(pivotInd-start)-1,pivotInd+1,end);    //Careful. Common mistake is to write k-pivotInd
                                                                            //instead of k-(pivotInd-start).
    }

    private static int partitionAroundPivot(int[] nums,int start,int end){
        int pivot=nums[start], split=start+1;
        for(int i=start+1;i<=end;i++){
            if(nums[i]<pivot){
                swap(nums,split,i);
                split++;
            }
        }
        swap(nums,split-1,start);
        return split-1;
    }

    private static void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        System.out.println(minMoves2(new int[]{1,0,0,8,6}));
    }
}

