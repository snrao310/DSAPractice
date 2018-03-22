package Done;

import java.util.Stack;

/**
 * Created by S N Rao on 1/16/2017.
 *
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is
 * the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 *
 */
public class RemoveKDigitsLeetCode {

    public static String removeKdigits(String num, int k) {
        if(k==num.length()) return "0";
        if(k==0) return num;
        String s="";
        int len=num.length(),size=len-k;
        Stack<Integer> stack=new Stack();
        stack.push(Character.getNumericValue(num.charAt(0)));
        for(int i=1;i<len;i++){
            int curr=Character.getNumericValue(num.charAt(i));
            while(!stack.isEmpty() && k>0 && curr<stack.peek()){
                stack.pop();
                k--;
            }
            if(stack.isEmpty() && curr==0)
                continue;
            else
                stack.push(curr);
        }
        while(!stack.isEmpty()){
            s+=Integer.toString(stack.pop());
        }
        s=new StringBuilder(s).reverse().toString();
        if(s.equals("")) return "0";
        size=Math.min(size,s.length());
        return s.substring(0,size);
    }

    public static void main(String args[]){
        System.out.print(removeKdigits("10200",1));
    }
}
