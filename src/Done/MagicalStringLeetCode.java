package Done;

/**
 * Created by S N Rao on 2/6/2017.
 *
 * A magical string S consists of only '1' and '2' and obeys the following rules:
 *
 * The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.
 *
 * The first few elements of string S is the following: S = "1221121221221121122……"
 *
 * If we group the consecutive '1's and '2's in S, it will be:
 *
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 *
 * and the occurrences of '1's or '2's in each group are:
 *
 * 1 2	2 1 1 2 1 2 2 1 2 2 ......
 *
 * You can see that the occurrence sequence above is the S itself.
 *
 * Given an integer N as input, return the number of '1's in the first N number in the magical string S.
 *
 * Note: N will not exceed 100,000.
 *
 * Example 1:
 * Input: 6
 * Output: 3
 * Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 *
 */
public class MagicalStringLeetCode {

    //Brute force. O(n) space and time.
    public static int magicalString(int n) {
        if(n==0) return 0;
        if(n<4) return 1;
        int[] magicString=new int[n+1];
        magicString[0]=1;magicString[1]=2;magicString[2]=2;
        int ones=1,pos=3;int val=1;
        for(int i=2;i<n;i++){
            if(magicString[i]==1){
                ones++;
                if(pos<n)
                    magicString[pos++]=val;
            }
            else{
                if(pos<n){
                    magicString[pos++]=val;
                    magicString[pos++]=val;
                }
            }
            val=(val==1)?2:1;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(magicalString(6));
    }

}

