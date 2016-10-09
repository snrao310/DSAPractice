/**
 * Created by S N Rao on 10/3/2016.
 */
public class ProductOfArrayExceptSelfLeetCode {

    public static int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        int oldProd=1;
        int prev=1;
        for(int i=0;i<nums.length;i++){
            result[i]=oldProd*prev;
            oldProd=result[i];
            prev=nums[i];
        }

        int newProd=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]*=newProd;
            newProd*=nums[i];
        }

        return result;

    }

    public static void main(String args[]){
        int input[]={1,3,2,5,6};
        int result[]=productExceptSelf(input);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
