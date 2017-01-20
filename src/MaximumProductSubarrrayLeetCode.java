/**
 * Created by S N Rao on 1/19/2017.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 */
public class MaximumProductSubarrrayLeetCode {

    //My O(n) solution. Very complex.
    //////////////////////////////////////////////////////////////////////////////////////////////
    public static int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int max=nums[0],s=0;
        for(int i=0;i<=nums.length;i++){
            if(i==nums.length || nums[i]==0){
                int m=maxProdHelp(nums,s,i-1);
                if(m>max) max=m;
                if(i!=nums.length && 0>max) max=0;
                s=i+1;
            }
        }
        return max;
    }

    private static int maxProdHelp(int[] nums,int s, int e){
        if(s>e) return 0;
        if(s==e) return nums[s];
        int c=0;
        for(int i=s;i<=e;i++){
            if(nums[i]<0) c++;
        }
        if((c&1)==0) return prod(nums,s,e);

        int i=s,j=e;
        while(nums[i]>0)i++;
        while(nums[j]>0)j--;
        return Math.max(prod(nums, s,j-1),prod(nums,i+1,e));
    }

    private static int prod(int[] nums,int s, int e){
        int p=1;
        for(int i=s;i<=e;i++)
            p*=nums[i];
        return p;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    //LeetCode O(n) very beautiful solution.
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int maxProduct2(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max=nums[0],min=nums[0],res=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp=max;
            max=Math.max(Math.max(nums[i]*max, nums[i]*min),nums[i]);
            min=Math.min(Math.min(nums[i]*temp, nums[i]*min),nums[i]);
            res=Math.max(res,max);
        }
        return res;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String args[]){
        System.out.println(maxProduct(new int[]{0}));
    }
}
