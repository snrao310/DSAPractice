/**
 * Created by snrao on 10/1/16.
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements
 * appear exactly twice. Find the two elements that appear only once.
 *
 */
public class SingleNumberIIILeetCode {

    public static int[] singleNumber3(int[] nums) {

        int result[]={0,0};

        int axorb=0;
        for(int i=0;i<nums.length;i++){
            axorb^=nums[i];
        }

        axorb &= (-axorb);   //smart way to get number with only least significant set bit, set.
                            // eg for 0110010, it gives 0000010. Awesome Bit manipulation method.
        for(int i=0;i<nums.length;i++){
            if((axorb & nums[i])==0){
                result[0]^=nums[i];
            }

            else{
                result[1]^=nums[i];
            }
        }
        return result;
    }




    public static void main(String args[]){
        int input3[]={2,3,2,4,3,5,6,7,7,6};

        int result3[]=singleNumber3(input3);
        for(int i=0;i<result3.length;i++){
            System.out.println(result3[i]);
        }


    }
}
