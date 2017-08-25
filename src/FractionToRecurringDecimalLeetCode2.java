import java.util.HashMap;

/**
 * Created by S N Rao on 8/24/2017.
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
public class FractionToRecurringDecimalLeetCode2 {

    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb=new StringBuilder();
        HashMap<Long,Integer> remainderToIndex=new HashMap<>();

        if(numerator==0) return "0";
        else if(denominator==1) return Integer.toString(numerator);
        if(numerator==denominator) return "1";

        if((numerator<0)^(denominator<0)) sb.append("-");
        long n=Math.abs((long) numerator), d=Math.abs((long) denominator);
        long q=n/d, r=n%d;
        sb.append(Long.toString(q));
        int i=sb.length()+1;
        if(r!=0) sb.append('.');
        while(r!=0){
            if(remainderToIndex.containsKey(r)){
                int ind=remainderToIndex.get(r);
                String s=sb.substring(0,ind)+'('+sb.substring(ind)+')';
                return s;
            }
            remainderToIndex.put(r,i++);
            r*=10;
            q=r/d;
            r=r%d;
            sb.append(Long.toString(q));
        }
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.print(fractionToDecimal(-1,-2147483648));
    }
}
