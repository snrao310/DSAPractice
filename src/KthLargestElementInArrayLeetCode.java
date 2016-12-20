import java.util.Random;

/**
 * Created by snrao on 12/19/16.
 *Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 */
public class KthLargestElementInArrayLeetCode {

    public static int findKthLargest(int[] nums, int k) {
        return randomizedSelection(nums,k,0,nums.length-1);
    }

    //Same as randomized selection using quicksort logic, but k is counted from end instead of start
    public static int randomizedSelection(int[] nums, int k, int start, int end){
        Random random=new Random();
        int pivot=start + random.nextInt(end-start+1);
        int temp=nums[pivot];
        nums[pivot]=nums[start];
        nums[start]=temp;
        pivot=start;
        int part=start+1;
        for(int i=start;i<=end;i++){
            if(nums[i]<nums[pivot]) {
                temp=nums[part];
                nums[part]=nums[i];
                nums[i]=temp;
                part++;
            }
        }
        temp=nums[part-1];
        nums[part-1]=nums[pivot];
        nums[pivot]=temp;
        pivot=part-1;

        if(((end-start+1) - (pivot-start))==k)
            return nums[pivot];
        if(((end-start+1) - (pivot-start)) >k)
            return randomizedSelection(nums,k,pivot+1,end);
        else
            return randomizedSelection(nums,k- (end-pivot+1),start,pivot-1);
    }


    public static void main(String args[]){
        System.out.print(findKthLargest(new int[]{1,2,3,4,5,6}, 6));
    }
}
