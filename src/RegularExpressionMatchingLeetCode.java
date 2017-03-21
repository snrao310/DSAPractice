/**
 * Created by S N Rao on 3/20/2017.
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
public class RegularExpressionMatchingLeetCode {

    //Straightforward recursive backtracking solution. Barely passes time limit on leetcode since it does lot of calls
    //with same parameters multiple times, so can use a DP hashmap by using concatenated s and p with delimiter in
    //between as the key and boolean as the value. But, the next function (isMatchDP) uses a more cleaner approach,
    //even though it goes through all possible combinations.
    public static boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0) return true;
        if(p.length()==0) return false;
        if(p.length()==1){
            if(s.length()!=1) return false;
            else if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') return true;
            else return false;
        }
        char ch1=p.charAt(0);
        char ch2=p.charAt(1);
        if(ch2=='*'){
            if(isMatch(s,p.substring(2))) return true;
            int i=0;
            while(i<s.length() && (s.charAt(i)==ch1 || ch1=='.')){
                if(isMatch(s.substring(i+1),p.substring(2))) return true;
                i++;
            }
        }
        else if(s.length()!=0 && (ch1==s.charAt(0) || ch1=='.')){
            if(isMatch(s.substring(1),p.substring(1))) return true;
        }
        return false;
    }

    //dp[i][j] is true if s[0..i-1] matches p[0..j-1]
    public static boolean isMatchDP(String s, String p){
        int m=s.length()+1,n=p.length()+1;
        boolean[][] dp=new boolean[m][n];
        dp[0][0]=true; //both null strings;
        for(int i=1;i<m;i++)   //p is null;
            dp[i][0]=false;
        for(int i=1;i<n;i++)   //s is null;
            dp[0][i]= i>1 && p.charAt(i-1)=='*' && dp[0][i-2];

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(p.charAt(j-1)!='*')
                    dp[i][j]= dp[i-1][j-1] && (p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='.');
                else
                    dp[i][j]= dp[i][j-2] || (dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'));
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String args[]){
        System.out.println(isMatch("aab","c*a*ab"));
        System.out.println(isMatch("aab","c*a*aaab"));
        System.out.println(isMatch("a" ,"ab*"));
    }
}
