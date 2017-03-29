import java.util.Arrays;

/**
 * Created by S N Rao on 3/29/2017.
 */
public class CountingInversions {

    static int inversions;
    public static int reversePairs(int[] nums) {
        if(nums.length==0) return 0;
        inversions=0;
        mergeSortFunction(nums);
        return inversions;
    }

    private static void mergeSortFunction(int[] nums){
        int len=nums.length;
        if(len==1)
            return;

        //Divide
        int[] A= Arrays.copyOfRange(nums,0,len/2);
        int[] B= Arrays.copyOfRange(nums,len/2,len);
        mergeSortFunction(A);
        mergeSortFunction(B);

        //Merge step with counting inversion
        int j=0,k=0;
        for(int i=0;i<len;i++){
            if(A[j]<=B[k])
                nums[i]=A[j++];
            else {
                nums[i] = B[k++];
                inversions+=A.length-j;     //adding inversions here.
            }

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
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
        System.out.println(reversePairs(new int[]{2,4,3,5,1}));
    }
}
