import java.util.Stack;

/**
 * Created by S N Rao on 1/11/2017.
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division
 * should truncate toward zero.
 * You may assume that the given expression is always valid.
 *
 */
public class BasicCalculatorIILeetCode {

    public static int calculate(String s) {
        Stack<Integer> stack=new Stack();
        int currNumber=0,result=0;
        char prevSign='+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                currNumber=(currNumber*10)+Character.getNumericValue(ch);
            }
            if((!Character.isDigit(ch) && ch!=' ') ||i==s.length()-1) {
                if(prevSign == '+')
                    stack.push(currNumber);
                if(prevSign=='-')
                    stack.push(-currNumber);
                if(prevSign=='*')
                    stack.push(stack.pop()*currNumber);
                if(prevSign=='/')
                    stack.push(stack.pop()/currNumber);
                prevSign=ch;
                currNumber=0;
            }
        }
        while (!stack.empty())
            result+=stack.pop();
        return result;
    }

    public static void main(String args[]){
        System.out.print(calculate(" 3+5 / 2 "));
    }
}
