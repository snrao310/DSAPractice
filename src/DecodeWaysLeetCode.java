/**
 * Created by S N Rao on 1/24/2017.
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 *
 */
public class DecodeWaysLeetCode {

    public static int numDecodings(String s) {
        if(s.length()==0 || s.charAt(0)=='0') return 0;
        int result=1,prevResult=1;
        char prev=s.charAt(0);
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='0') {
                if(prev>'2' || prev<'1') return 0;
                result=prevResult;
            }
            else{
                int extra=(prev=='1' || (prev=='2' && ch<='6'))?prevResult:0;
                prevResult=result;
                result+=extra;
            }
            prev=ch;
        }
        return result;
    }

    public  static void main(String args[]){
        System.out.println(numDecodings("100"));
        System.out.println(numDecodings("17"));
    }
}
