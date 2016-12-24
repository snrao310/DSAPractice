/**
 * Created by snrao on 12/23/16.
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your
 * algorithm?
 *
 */
public class HIndexIILeetCode {

    public static int hIndex(int[] citations) {
        if(citations.length==0)
            return 0;
        int low=0,high=citations.length-1;
        int hIndex=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(citations[mid]>=(citations.length-mid)){
                hIndex=citations.length-mid;
                high=mid-1;
            }

            else
                low=mid+1;

        }
        return hIndex;
    }

    public static void main(String args[]){
        System.out.println(hIndex(new int[]{0,2,4,5,6}));
    }
}
