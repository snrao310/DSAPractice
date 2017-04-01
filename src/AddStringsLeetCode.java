/**
 * Created by S N Rao on 3/31/2017.
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class AddStringsLeetCode {

    public static String addStrings(String num1, String num2) {
        char[] n1=num1.toCharArray();
        char[] n2=num2.toCharArray();
        int len=Math.max(n1.length,n2.length)+1;
        char[] sum=new char[len];
        int i1=n1.length-1, i2=n2.length-1, carry=0;
        for(int i=len-1;i>=0;i--){
            int a=(i1>=0)?Character.getNumericValue(n1[i1--]):0;
            int b=(i2>=0)?Character.getNumericValue(n2[i2--]):0;
            int c=a+b+carry;
            sum[i]=(char)((c%10)+'0');
            carry=(c>9)?1:0;
        }
        String res=new String(sum);
        return (res.charAt(0)=='0')?res.substring(1):res;
    }

    public static void main(String args[]){
        System.out.println(addStrings("123","7"));
    }
}
