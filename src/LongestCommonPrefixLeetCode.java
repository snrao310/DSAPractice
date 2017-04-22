/**
 * Created by S N Rao on 4/21/2017.
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class LongestCommonPrefixLeetCode {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        StringBuilder sb=new StringBuilder();
        for(int i=0;;i++){
            if(i>=strs[0].length()) return sb.toString();
            char c=strs[0].charAt(i);
            for(String s: strs)
                if(i>=s.length() || s.charAt(i)!=c) return sb.toString();
            sb.append(c);
        }
    }

    public static void main(String args[]){
        System.out.print(longestCommonPrefix(new String[]{"abcd","abab","abr"})); //ab
    }
}
