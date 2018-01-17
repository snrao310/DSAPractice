/**
 * Created by S N Rao on 11/21/2017.
 *
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 */
public class RegularExpressionMatchingLeetCode2 {

    public static boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0) return true;
        if(p.length()==0) return false;
        if(p.length()==1){
            if(s.length()!=1) return false;
            if(p.charAt(0) ==s.charAt(0) || p.charAt(0)=='.') return true;
            else return false;
        }
        char c1=p.charAt(0);
        char c2=p.charAt(1);

        if(c2=='*') {
            if(isMatch(s,p.substring(2))) return true;
            int i=0;
            while(i<s.length() && (s.charAt(i)==c1 || c1=='.')) {
                if(isMatch(s.substring(i+1),p.substring(2)))
                    return true;
                i++;
            }
        }
        else{
            if(s.length()!=0 && (s.charAt(0)==c1 || c1=='.'))
                return isMatch(s.substring(1),p.substring(1));
        }
        return false;
    }

    public static boolean isMatchDP(String s, String p){
        int m=s.length()+1,n=p.length()+1;
        boolean[][] matchDP=new boolean[m][n];
        matchDP[0][0]=true;
        for(int i=1;i<m;i++)
            matchDP[i][0]=false;
        for(int i=1;i<n;i++)
            matchDP[0][i]=(i>1 && matchDP[0][i-2] && p.charAt(i-1)=='*');

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(p.charAt(j-1)!='*'){
                    matchDP[i][j]=(matchDP[i-1][j-1] && (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.'));
                }
                else{
                    matchDP[i][j]=(matchDP[i][j-2] || (matchDP[i-1][j] && (p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.')));
                }
            }
        }
        return matchDP[m-1][n-1];

    }



    public static void main(String[] args){
        System.out.println(isMatch("aab","c*a*ab"));
        System.out.println(isMatch("aab","c*a*aaab"));
        System.out.println(isMatch("a" ,"ab*"));
        System.out.println(isMatch("" ,".*"));
        System.out.println(isMatch("ab" ,".*"));
    }
}
