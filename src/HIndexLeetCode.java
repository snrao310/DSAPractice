/**
 * Created by snrao on 12/22/16.
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to
 * compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have
 * at least h citations each, and the other N − h papers have no more than h citations each."
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of
 * them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3
 * citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 */
public class HIndexLeetCode {

    //hashtable. Can sort if no extra space is allowed.
    public static int hIndex(int[] citations) {
        int[] hashmap=new int[citations.length+1];
        for (int i=0;i<citations.length;i++){
           if(citations[i]>citations.length)
               hashmap[citations.length]++;
            else
                hashmap[citations[i]]++;
        }

        int hIndex=0, counted=0;
        for(int i=0;i<hashmap.length-1;i++){
            counted+=hashmap[i];
            if(citations.length-counted>=i+1)
                hIndex=i+1;
        }
        return hIndex;
    }

    public static void main(String args[]){
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
