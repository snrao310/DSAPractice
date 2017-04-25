/**
 * Created by S N Rao on 4/24/2017.
 *
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 */
public class ImplementStrStrLeetCode {

    //Can use the naive O(mn) approach. But this is the smarter KMP algorithm. O(m+n) time O(n) extra space. n is length
    //of needle. Same algorithm used in ShortestPalindromeLeetCode.
    //Video to understand (https://www.youtube.com/watch?v=GTJr8OvyEVQ)
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        int[] prefixes=buildPrefixArray(needle.toCharArray());
        int j=0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(j)) j++;
            else if(j!=0) {j=prefixes[j-1]; i--;}
            if(j==needle.length()) return i-needle.length()+1;
        }
        return -1;
    }

    private static int[] buildPrefixArray(char[] s){
        int[] res=new int[s.length];
        int j=0; res[0]=0;
        for(int i=1;i<s.length;i++){
            if(s[i]==s[j]) {j++; res[i]=j;}
            else if(j!=0) {j=res[j-1]; i--;}
            else res[i]=j;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(strStr("Mississipi","issip")); //4
    }
}
