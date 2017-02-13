import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by snrao on 2/13/17.
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property
 * where counts[i] is the number of smaller elements to the right of nums[i].
 *
 */
public class CountOfSmallerNumbersAfterSelfLeetCode {

    //Modification of counting inversions problem.
    public static List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        if(n==0) return new ArrayList<>();
        int[] resultArray=new int[n],index=new int[n];
        for(int i=0;i<n;i++) index[i]=i;
        mergeSortFunction(index,nums,resultArray);
        List<Integer> result=new ArrayList<>();
        for(int num: resultArray) result.add(num);
        return result;
    }

    private static void mergeSortFunction(int[] index, int[] nums, int[] resultArray) {
        if(index.length==1) return;
        int n=index.length;
        int[] A=Arrays.copyOfRange(index, 0, n/2), B=Arrays.copyOfRange(index, n/2, n);
        mergeSortFunction(A, nums, resultArray);
        mergeSortFunction(B, nums, resultArray);
        int count=0,i=0,j=0;
        for(int k=0;k<n;k++){
            if(nums[A[i]]<=nums[B[j]]){
                index[k]=A[i];
                resultArray[A[i]]+=count;
                i++;
                if(i==A.length){
                    k++;
                    while(j<B.length)
                        index[k++]=B[j++];
                    break;
                }
            }
            else{
                count++;
                index[k]=B[j];
                j++;
                if(j==B.length){
                    k++;
                    while(i<A.length){
                        resultArray[A[i]]+=count;
                        index[k++]=A[i++];
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list=countSmaller(new int[]{-1,-1});
        for(int i: list)
            System.out.print(i+" ");
    }
}
