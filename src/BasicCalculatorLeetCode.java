import java.util.Stack;

/**
 * Created by S N Rao on 3/3/2017.
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers
 * and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 *
 */
public class BasicCalculatorLeetCode {

    //Stack operations. Not that hard.
    public static int calculate(String s) {
        Stack<String> stack=new Stack<>();
        int cur=0;
        String operator="+";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                StringBuilder number=new StringBuilder();
                while(i<s.length() && Character.isDigit(s.charAt(i)))
                    number.append(s.charAt(i++));
                i--;
                if(operator.equals("+"))
                    cur+=Integer.parseInt(number.toString());
                else
                    cur-=Integer.parseInt(number.toString());
            }

            else if(ch=='('){
                stack.push(Integer.toString(cur));
                stack.push(operator);
                cur=0; operator="+";
            }

            else if(ch==')'){
                operator=stack.pop();
                int operand=Integer.parseInt(stack.pop());
                cur=(operator.equals("+"))? (operand+cur): (operand-cur);
            }

            else if(ch=='+')
                operator="+";
            else if(ch=='-')
                operator="-";
        }
        return cur;
    }

    public static void main(String args[]){
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
