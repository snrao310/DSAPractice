import java.util.Arrays;

/**
 * Created by S N Rao on 3/29/2017.
 */
public class MergeSort {

    private static void mergeSortFunction(int[] nums){
        int len=nums.length;
        if(len==1)
            return;

        //Divide
        int[] A= Arrays.copyOfRange(nums,0,len/2);
        int[] B= Arrays.copyOfRange(nums,len/2,len);
        mergeSortFunction(A);
        mergeSortFunction(B);

        //Merge step
        int j=0,k=0;
        for(int i=0;i<len;i++){
            if(A[j]<=B[k])
                nums[i]=A[j++];
            else
                nums[i]=B[k++];

            if(j==A.length){
                i++;
                while(k!=B.length)
                    nums[i++]=B[k++];
                break;
            }
            if(k==B.length){
                i++;
                while(j!=A.length)
                    nums[i++]=A[j++];
                break;
            }
        }
    }

    public static void main(String args[]){
        int[] arr={5,3,6,7,2,4,2,1};
        mergeSortFunction(arr);
        for(int i: arr)
            System.out.print(i+" ");
    }
}
