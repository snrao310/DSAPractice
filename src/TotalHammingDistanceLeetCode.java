/**
 * Created by S N Rao on 2/2/2017.
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 *
 * Note:
 * Elements of the given array are in the range of 0 to 10^9
 * Length of the array will not exceed 10^4.
 *
 */
public class TotalHammingDistanceLeetCode {

    public static int totalHammingDistance(int[] nums) {
        if(nums.length<=1) return 0;
        int res=0, mask=1;
        int[] onesCount=new int[32];
        for(int i=0;i<32;i++,mask<<=1) onesCount[31-i]=((mask&nums[0])!=0)?1:0;

        for(int i=1;i<nums.length;i++){
            mask=1;
            for(int j=31;j>=0;j--){
                if((mask&nums[i])!=0){
                    res+=(i-onesCount[j]);
                    onesCount[j]++;
                }
                else
                    res+=onesCount[j];
                mask<<=1;
            }
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(totalHammingDistance(new int[]{4,14,2}));
    }
}
