import java.util.Arrays;
import java.util.Random;

/**
 * Created by S N Rao on 1/18/2017.
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 *
 */
public class WiggleSortIILeetCode {
    //O(nlogn) time and O(n) space solution. Sorting part dominates.
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] tem=nums.clone();
        int i,j=nums.length-1,k=(nums.length%2==0)?nums.length/2-1:nums.length/2;
        for(i=0;i<nums.length;i++){
            nums[i]=(i%2==0)?tem[k--]:tem[j--];
        }
    }

    //O(n) time and O(n) space. Can do it in O(1) space after partitioning, using smart swaps, but too complicated to
    //understand for me. Try some other time probabaly.
    public static void wiggleSortFast(int[] nums) {
        int len=nums.length;
        partitionAroundMedian(nums,(int)Math.ceil((double)len/2),0,len-1);
        int[] tem=nums.clone();
        int j=len-1,k=(len%2==0)?len/2-1:len/2;
        for(int i=0;i<nums.length;i++){
            nums[i]=(i%2==0)?tem[k--]:tem[j--];
        }
    }

    private static void swap(int[] nums,int i1,int i2){
        int tem=nums[i1];
        nums[i1]=nums[i2];
        nums[i2]=tem;
    }

    //Partitions into 3 parts, elements less than pivot on the left, elements equal to in the middle, elements greater
    //than it at the right.
    private static void partitionAroundMedian(int[] nums,int k, int start, int end){
        if(end<=start || end-start+1<k) return;
        Random r=new Random();
        int ind=start + r.nextInt(end-start+1);
        int pivot=nums[ind];
        nums[ind]=nums[start];
        nums[start]=pivot;
        int firstGrt=start+1;
        int firstSame=start+1;
        for(int i=start+1;i<=end;i++){
            if(nums[i]<pivot){
                swap(nums,i,firstSame);
                if(firstGrt!=firstSame)
                    swap(nums,i,firstGrt);
                firstGrt++;firstSame++;
            }
            else if(nums[i]==pivot){
                swap(nums,i,firstGrt);
                firstGrt++;
            }
        }
        nums[start]=nums[firstSame-1];
        nums[firstSame-1]=pivot;
        int pivIndexStart=firstSame-1;
        int pivIndexEnd=firstGrt-1;
        int len=end-start;
        if(pivIndexStart<=(start+k-1) && pivIndexEnd>=(start+k-1)) return;
        else if(pivIndexEnd > (start+k-1)) partitionAroundMedian(nums,k,start,pivIndexStart-1);
        else partitionAroundMedian(nums,k-(pivIndexEnd-start)-1,pivIndexEnd+1,end);     //has to be k-(pivIndexEnd-start)-1, not k-pivIndexEnd-1. Its a common mistake.
    }

    public static void main(String args[]){
        int[] nums={1,3,2,5,6,7,8,5,5,5};
        wiggleSortFast(nums);
        for(int i: nums)
            System.out.print(i+" ");

    }
}
