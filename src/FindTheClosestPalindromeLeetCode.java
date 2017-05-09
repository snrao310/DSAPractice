/**
 * Created by S N Rao on 5/7/2017.
 *
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.
 *
 * The 'closest' is defined as absolute difference minimized between two integers.
 *
 * Example 1:
 * Input: "123"
 * Output: "121"
 *
 * Note:
 * The input n is a positive integer represented by string, whose length will not exceed 18.
 * If there is a tie, return the smaller one as answer.
 *
 */
public class FindTheClosestPalindromeLeetCode {

    public static String nearestPalindromic(String n) {
        Long num=Long.parseLong(n);
        Long l=findLarger(num+1);
        Long s=findSmaller(num-1);
        return ((num-s)>(l-num))?Long.toString(l):Long.toString(s);
    }

    private static Long findLarger(Long limit){
        String s="",n=Long.toString(limit);
        int len=n.length();

        //copying first half to second half to create palindrome number.
        if(len%2==0) s=n.substring(0,len/2)+(new StringBuilder(n.substring(0,len/2)).reverse().toString());
        else s= n.substring(0,len/2)+n.substring(len/2,len/2+1)+(new StringBuilder(n.substring(0,len/2)).reverse().toString());
        char[] num=n.toCharArray(), pal=s.toCharArray();

        //checking if pal is greater than num and if not making it greater.
        for(int i=0;i<len;i++){
            if(pal[i]>num[i])
                return Long.parseLong(String.valueOf(pal));
            else if(num[i]>pal[i]){
                for(int j=(len-1)/2;j>=0;j--){
                    if(pal[j]!='9'){
                        pal[j]++; pal[len-j-1]=pal[j];break;
                    }
                    else{
                        pal[j]='0';pal[len-j-1]='0';
                    }
                }
                return Long.parseLong(String.valueOf(pal));
            }
        }
        return Long.parseLong(String.valueOf(pal));
    }

    private static Long findSmaller(Long limit){
        String s="",n=Long.toString(limit);
        int len=n.length();

        //copying first half to second half to create palindrome number.
        if(len%2==0) s=n.substring(0,len/2)+(new StringBuilder(n.substring(0,len/2)).reverse().toString());
        else s= n.substring(0,len/2)+n.substring(len/2,len/2+1)+(new StringBuilder(n.substring(0,len/2)).reverse().toString());
        char[] num=n.toCharArray(), pal=s.toCharArray();

        //checking if pal is lesser than num and if not making it lesser.
        for(int i=0;i<len;i++){
            if(pal[i]<num[i])
                return Long.parseLong(String.valueOf(pal));
            else if(num[i]<pal[i]){
                for(int j=(len-1)/2;j>=0;j--){
                    if(pal[j]!='0'){
                        pal[j]--; pal[len-j-1]=pal[j];break;
                    }
                    else{
                        pal[j]='9';pal[len-j-1]='9';
                    }
                }
                if(pal[0]=='0'){
                    pal[len-1]='9';
                    return Long.parseLong(String.valueOf(pal).substring(1));
                }
                return Long.parseLong(String.valueOf(pal));
            }
        }
        return Long.parseLong(String.valueOf(pal));
    }

    public static void main(String args[]){
        System.out.println(nearestPalindromic("1001")); //999
    }
}
