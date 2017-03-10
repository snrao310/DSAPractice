/**
 * Created by S N Rao on 3/10/2017.
 *
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return
 * the shortest palindrome you can find by performing this transformation.
 *
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 *
 */
public class ShortestPalindromeLeetCode {

    //Using steps used in KMP Pattern matching Algorithm: Video to understand (https://www.youtube.com/watch?v=GTJr8OvyEVQ)
    public static String shortestPalindrome(String s) {
        String rev=new StringBuilder(s).reverse().toString();
        char[] kmpString=(s+"-"+rev).toCharArray();     //concatenating s with reverse of s with '-' in between them.

        //KMP Algorithm to find suffixes before pattern mathching
        int[] suffixLength=new int[kmpString.length];
        int i=0,j; suffixLength[0]=0;
        for(j=1;j<kmpString.length;j++){
            if(kmpString[i]==kmpString[j]) {
                suffixLength[j]=suffixLength[j-1]+1;
                i++;
            }
            else{
                while(i!=0 && kmpString[i]!=kmpString[j]) {
                    i = suffixLength[i - 1];
                }
                if(kmpString[i]==kmpString[j]) {
                    suffixLength[j]=i+1;
                    i++;
                }
                else suffixLength[j]=0;
            }
        }
        return rev.substring(0,rev.length()-suffixLength[kmpString.length-1])+s;
    }

    public static void main(String args[]){
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }
}
