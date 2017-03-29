import java.util.Arrays;

/**
 * Created by S N Rao on 3/29/2017.
 *
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 *
 */
public class WildcardMatchingLeetCode {

    //Backtracking with dp. dp[i][j]=1 if s[i..slen] matches p[j..plen]. Otherwise, dp[i][j]=0; dp[i][j]=-1 if not explored
    //yet. dp[slen][x] is when s is empty string and dp[x][plen] is when p is empty string.
    public static boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()+1][p.length()+1];
        for(int[] dpRow:dp) Arrays.fill(dpRow,-1);
        return backTrackFunction(s.toCharArray(),p.toCharArray(),0,0,dp);
    }

    private static boolean backTrackFunction(char[] s,char[] p,int startS,int startP, int[][] dp){
        int plen=p.length, slen=s.length;
        if(startP==plen && startS==slen)    //both are empty strings
            return true;
        if(startP==plen && startS!=slen)    //p is empty string
            return false;
        if(dp[startS][startP]!=-1)          //already visited
            return dp[startS][startP]==1;
        if(startS==slen && startP!=plen){   //s is empty string, matches only if p only has stars('*').
            int i=startP;
            while(i<plen){
                if(p[i++]!='*'){
                    dp[startS][startP]=0;
                    return false;
                }
            }
            return true;
        }


        if(p[startP]!='*'){                                 //first element of p is not '*'
            if(p[startP]!=s[startS] && p[startP]!='?'){     //then first elements should match. Otherwise strings don't match.
                dp[startS][startP]=0;
                return false;
            }
            else{                                           //go till index where it stops matching and recurse from there.
                int newStartS=startS+1, newStartP=startP+1;
                while(newStartS<slen && newStartP<plen && (p[newStartP]==s[newStartS] || p[newStartP]=='?')){
                    newStartP++; newStartS++;
                }
                dp[startS][startP]=(backTrackFunction(s,p,newStartS,newStartP,dp))?1:0;
                return dp[startS][startP]==1;
            }
        }
        else{       //p starts with '*'. Try all sequence lengths for s.
            for(int i=startS;i<=s.length;i++){
                if(backTrackFunction(s,p,i,startP+1,dp)){
                    dp[startS][startP]=1;
                    return true;
                }
            }
            dp[startS][startP]=0;
            return false;
        }
    }

    public static void main(String args[]){
        System.out.println(isMatch("aa","a"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }
}
