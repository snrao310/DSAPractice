/**
 * Created by S N Rao on 3/8/2017.
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity
 * O(n).
 *
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */
public class MinimumWindowSubstringLeetCode {


    // 1. Use two pointers: start and end to represent a window.
    // 2. Move end to find a valid window.
    // 3. When a valid window is found, move start to find a smaller window.
    public static String minWindow(String s, String t) {
        int[] map=new int[58];  //from 67 ('A') to 122 ('z')
        for(int i=0;i<t.length();i++)
            map[t.charAt(i)-'A']++;

        int end=0, beg=0, counter=t.length(), head=0, minLength=Integer.MAX_VALUE;
        while(end<s.length()){
            int c=s.charAt(end)-'A';
            if(map[c]>0)
                counter--;
            map[c]--;
            while(counter==0){
                if(minLength>end-beg+1){
                    head=beg; minLength=end-beg+1;
                }
                c=s.charAt(beg)-'A';
                if(map[c]==0)
                    counter++;
                map[c]++;
                beg++;
            }
            end++;
        }
        return (minLength==Integer.MAX_VALUE)?"":s.substring(head, head+minLength);
    }

    public static void main(String args[]){
        System.out.print(minWindow("ADOBECODEBANC","ABC"));
    }
}
