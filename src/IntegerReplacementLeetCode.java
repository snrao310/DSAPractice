import java.util.HashMap;

/**
 * Created by snrao on 1/2/17.
 *
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 */
public class IntegerReplacementLeetCode {

    //Top-Down Dynamic Programming. Bottom up will not work in this case.
    public static int integerReplacement(int n) {
        HashMap<Integer,Integer> dp=new HashMap<>();
        dp.put(1,0);dp.put(2,1);  //array leads to memory exceeded.
        return integerReplacement(n,dp);
    }

    private static int integerReplacement(int n, HashMap<Integer,Integer> dp){
        if(dp.containsKey(n)) return dp.get(n);

        if(n%2==0) dp.put(n,1+integerReplacement(n/2,dp));
        else dp.put(n,Math.min(1+integerReplacement(n-1,dp),2+integerReplacement(1+(n-1)/2,dp))); //n+1 will give overflow for input Integer.MAX_VALUE
        return dp.get(n);
    }

    public static void main(String args[]){
        System.out.println(integerReplacement(8));
    }
}
