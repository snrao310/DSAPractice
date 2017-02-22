/**
 * Created by S N Rao on 2/22/2017.
 *
 * For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.
 *
 * Now given a string representing n, you should return the smallest good base of n in string format.
 *
 * Example 1:
 * Input: "13"
 * Output: "3"
 * Explanation: 13 base 3 is 111.
 *
 * Example 2:
 * Input: "4681"
 * Output: "8"
 * Explanation: 4681 base 8 is 11111.
 *
 * Example 3:
 * Input: "1000000000000000000"
 * Output: "999999999999999999"
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.
 *
 * Note:
 * The range of n is [3, 10^18].
 * The string representing n is always valid and will not have leading zeros.
 *
 */
public class SmallestGoodBaseLeetCode {


    //The input can be stored in a long (whose limit is greater than 10^18). We need to find k, for 1+k^1+k^2+k^3+...+k^d=n.
    //The smallest possible base is k=2, with has the longest possible representation, i.e., largest d. So, to find the
    //smallest base means to find the longest possible representation "11111....1" based on k. As n<=10^18, so n<(1<<60).
    //So worst largest we can get is 60 1s when n is 10^18. Maximum 1s will exist when base is 2. So I get this value and
    //store it as maxBits.
    //We iterate the length of the representation from maxBits to 2 (2 can always be valid, with base=n-1), and check whether
    //a given length can be valid.

    //For a given length d, we use binary search to check whether there is a base k which satisfies 1+k^1+k^2+...k^d=n.
    //The left limit is 1, and the right limit is pow(n,1.0/(d-1));, i.e., the d th square root of n.
    public static String smallestGoodBase(String n) {
        long num=Long.parseLong(n);
        int maxBits=(int)(Math.log(num)/Math.log(2))+1;
        for(int i=maxBits;i>=2;i--){
            long m=solve(i,num);
            if(m!=0)
                return Long.toString(m);
        }
        return "";
    }

    private static long solve(int maxBits,long n){
        long low=1, high=(long)Math.pow(n,1.0/(maxBits-1));
        if(maxBits==2) high=n-1;    //This is coz of stupid approximation of Math.pow when power is 1.
        while(low<=high){
            long mid=low+(high-low)/2;
            long sum=1, cur=1, j=1;
            while(j<maxBits){
                j++; cur*=mid;
                sum+=cur;
            }
            if(sum==n) return mid;
            if(sum>n) high=mid-1;
            else low=mid+1;
        }
        return 0;
    }

    public static void main(String args[]){
        System.out.print(smallestGoodBase("727004545306745403"));
    }
}
