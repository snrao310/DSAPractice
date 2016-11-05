/**
 * Created by snrao on 11/5/16.
 */
public class IntegerBreakLeetCode {

    //calculates max product of a split which sums up to be n. Using DP.
    public static int integerBreak(int n) {

        int dp[]=new int[n+1];
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;

        dp[0]=0; dp[1]=1; dp[2]=1;

        int max,m;
        for(int i=3;i<=n;i++){
            max=-1;
            for(int j=1;j<=(i/2);j++){
                int p1=j*(i-j);
                int p2=dp[j]*(i-j);
                int p3=j*dp[i-j];
                int p4=dp[j]*dp[i-j];

                m=Math.max(p1,Math.max(p2,Math.max(p3,p4)));
                if(m>max)
                    max=m;
            }
            dp[i]=max;
        }
        return dp[n];
    }

    public static void main(String[] args){
        System.out.print(integerBreak(5));
        String k="dfd";
        int i=k.length();
    }
}
