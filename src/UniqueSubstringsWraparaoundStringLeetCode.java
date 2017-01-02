/**
 * Created by snrao on 1/2/17.
 *
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will
 * look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * Now we have another string p. Your job is to find out how many unique non-empty substrings of p are
 * present in s. In particular, your input is the string p and you need to output the number of different
 * non-empty substrings of p in the string s.
 * Note: p consists of only lowercase English letters and the size of p might be over 10000.
 */
public class UniqueSubstringsWraparaoundStringLeetCode {

    //Dynamic programming.
    public static int findSubstringInWraproundString(String p) {
        if(p.equals(""))return 0;
        int countNow=0,count[]=new int[26];
        char prev=(char)(p.charAt(0)-1);
        for(int i=0;i<p.length();i++){
            char curr=p.charAt(i);
            if(curr==prev+1) {
                countNow++;
                count[curr - 'a'] = Math.max(countNow, count[curr-'a']);
            }
            else {
                count[curr - 'a'] = Math.max(1, count[curr - 'a']);
                countNow=1;
            }
            prev=curr;
            if(prev=='z') prev=96;
        }
        int sum=0;
        for(int i=0;i<26;i++){
            sum+=count[i];
        }
        return sum;
    }

    public static void main(String args[]){
        System.out.print(findSubstringInWraproundString("abcxedbcvv"));
    }

}
