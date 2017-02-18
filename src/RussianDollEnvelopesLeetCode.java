import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by S N Rao on 2/17/2017.
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into
 * another if and only if both the width and height of one envelope is greater than the width and height of the other
 * envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 */
public class RussianDollEnvelopesLeetCode {

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return 1;           //sorting based on
                if(o1[0]<o2[0]) return -1;          //width in ascending order.
                else{
                    if(o1[1]>o2[1]) return -1;      //For same width, sorting based on
                    if(o1[1]<o2[1]) return 1;       //height in descending order.
                    return 0;
                }
            }
        });

        return LongestIncreasingSubsequenceLength(envelopes);  //LIS of heights only will give the answer.
    }

    //Non-intuitive O(nlogn) method. This is the problem encountered in LongestIncreasingSubsequenceLeetCode.
    private static int LongestIncreasingSubsequenceLength(int[][] nums){
        int[] tails=new int[nums.length];
        int size=0;

        for(int i=0;i<nums.length;i++){
            int cur=nums[i][1];
            int low=0, high=size-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(tails[mid]>cur)
                    high=mid-1;
                else if(tails[mid]<cur)
                    low=mid+1;
                else{
                    low=mid;
                    break;
                }
            }
            tails[low]=cur;
            if(low==size)
                size++;
        }
        return size;
    }

    public static void main(String args[]){
        System.out.print(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
}
