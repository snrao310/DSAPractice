import java.util.HashMap;

/**
 * Created by S N Rao on 1/25/2017.
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * For example,
 *
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 */
public class FractionToRecurringDecimalLeetCode {

    public static String fractionToDecimal(int numerator, int denominator) {
        String res=((numerator<0)^(denominator<0))?"-":"";
        if(denominator==numerator) return "1";
        if(numerator==0) return "0";
        long n=Math.abs((long)numerator),d=Math.abs((long)denominator),q,r;
        HashMap<Long,Integer> map=new HashMap<>();
        q=n/d;
        r=n%d;
        res+=Long.toString(q);
        if(r==0) return res;
        else res+='.';
        map.put(r,res.length());
        while (r!=0){
            n=r*10;
            q=n/d;
            r=n%d;
            res+=Long.toString(q);
            if(map.containsKey(r)){
                int ind=map.get(r);
                return res.substring(0,ind)+"("+res.substring(ind)+")";
            }
            map.put(r,res.length());
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(fractionToDecimal(-1,-2147483648));
    }
}
