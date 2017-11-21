
/**
 * Created by S N Rao on 11/14/2017.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 *
 */
public class LongestPalindromicSubstringLeetCode2 {

    public static String longestPalindrome(String s) {
        int maxLength=0, left=0,right=0;

        for(int i=0;i<2*s.length();i++){
            int palLength=0;
            int back,front=i;
            if((i&1)==0){ //even
                back=(i/2)-1;
                front=(i/2)+1;
                palLength=1;
            }
            else{
                back=(i/2);
                front=back+1;
            }

            while(back>=0 && front<s.length() && s.charAt(back)==s.charAt(front)) {
                palLength += 2;
                back--; front++;
            }

            if(maxLength<palLength){
                left=back+1; right=front-1;
                maxLength=palLength;
            }
        }

        return s.substring(left,right+1);
    }

    public static void main(String args[]){
        System.out.println(longestPalindrome("cbbcd"));
    }
}
