/**
 * Created by S N Rao on 4/6/2017.
 *
 * Given two strings representing two complex numbers.
 *
 * You need to return a string representing their multiplication. Note i^2 = -1 according to the definition.
 *
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 *
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 *
 * Note:
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of
 * [-100, 100]. And the output should be also in this form.
 *
 */
public class ComplexNumberMultiplicationLeetCode {

    public static String complexNumberMultiply(String a, String b) {
        String[] parts=a.split("\\+");
        int a1=Integer.parseInt(parts[0]), b1=Integer.parseInt(parts[1].substring(0,parts[1].length()-1));
        parts=b.split("\\+");
        int a2=Integer.parseInt(parts[0]), b2=Integer.parseInt(parts[1].substring(0,parts[1].length()-1));

        int a3=(a1*a2)+(b1*b2)*(-1);
        int b3=(a1*b2)+(b1*a2);

        return a3+"+"+b3+"i";
    }

    public static void main(String args[]){
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(complexNumberMultiply("1+-3i", "1+1i"));
    }
}
