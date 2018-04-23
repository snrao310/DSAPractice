package Done;

import javax.print.DocFlavor;

/**
 * Created by S N Rao on 1/16/2017.
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class MultiplyStringsLeetCode {

    public static String multiply(String num1,String num2){
        int n=num1.length()-1,m=num2.length()-1;
        int product[]=new int[n+m+2];
        for(int i=n;i>=0;i--){
            for (int j=m;j>=0;j--){
                int a=Character.getNumericValue(num1.charAt(i));
                int b= Character.getNumericValue(num2.charAt(j));
                int prod=a*b, c=product[i+j+1]+prod;
                product[i+j+1]=c%10;
                product[i+j]+=c/10;
            }
        }

        boolean start=false;
        String res="";
        for(int i=0;i<n+m+2;i++){
            if(!start && product[i]==0) continue;
            if(product[i]!=0)
                start=true;
            res+=Integer.toString(product[i]);
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(multiply("5","729"));
        System.out.println(5*729);
    }
}
