/**
 * Created by S N Rao on 1/19/2017.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 *
 */
public class LongestPalindromicSubstringLeetCode {

    public static String longestPalindrome(String s) {
        int len=s.length(), max=1, start=0, end=0;
        for(int i=1;i<2*len-2;i++){
            int j,k,plen;
            if((i&1)==0){
                j=i/2-1;k=j+2;plen=1;
            }
            else{
                j=i/2;k=j+1;plen=0;
            }
            while(s.charAt(j)==s.charAt(k)){
                plen+=2; j--; k++;
                if(j<0 || k>len-1) break;
            }
            if(plen>max){
                max=plen; start=j+1; end=k-1;
            }
        }
        return s.substring(start,end+1);
    }

    public static void main(String args[]){
        System.out.println(longestPalindrome("cbbd"));
    }
}
