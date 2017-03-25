/**
 * Created by S N Rao on 3/24/2017.
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than
 * ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 */
public class MajorityElementLeetCode {

    //Majority voting algorithm. But second loop to verify if majority exists, is not required, because the question says
    //that majority exists. If we don't know if majority exists, then we need to do a second pass and check that result
    //of first pass is actually majority. The first pass finds majority if it exists. Second pass checks if majority exists
    //by checking the count of result of first pass and checking if its greater than half. Complexity is O(n).
    public static int majorityElement(int[] nums) {
        int count=0, majority=0;
        for(int i=0;i<nums.length;i++){
            if(count==0) {
                majority = nums[i];
                count++;
            }
            else{
                if(majority==nums[i])
                    count++;
                else count--;
            }
        }
        return majority;
    }

    //Awesome bit manipulation technique. For each bit of the 32 bits, go through the array and check the majority value
    //for this bit. If majority elements have this bit as 1, then result has this bit as 1, else this bit is 0 in majority
    //element. Complexity is O(32n)=O(n).
    public static int majorityElementBM(int[] nums) {
        int majority=0, half=nums.length/2;
        for(int i=0,mask=1;i<32;i++,mask<<=1){
            int oneCount=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&mask)!=0)
                    oneCount++;
            }
            if(oneCount>half)
                majority |= mask;
        }
        return majority;
    }

    public static void main(String args[]){
        System.out.print(majorityElementBM(new int[]{1,2,3,4,3,4,3,3,3,3,3,}));
    }
}
