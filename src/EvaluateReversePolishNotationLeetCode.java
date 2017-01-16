import java.util.Stack;

/**
 * Created by S N Rao on 1/16/2017.
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 *
 */
public class EvaluateReversePolishNotationLeetCode {

    public static int evalRPN(String[] tokens) {
        if(tokens.length==1)
            return Integer.parseInt(tokens[0]);
        Stack<Integer> stack=new Stack<>();
        for(String s:tokens){
            if(s.equals("*"))
                stack.push(stack.pop()*stack.pop());
            else if(s.equals("/")){
                int a=stack.pop(),b=stack.pop();
                stack.push(b/a);
            }
            else if(s.equals("+"))
                stack.push(stack.pop()+stack.pop());
            else if(s.equals("-"))
                stack.push(-(stack.pop()-stack.pop()));
            else
                stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    public static void main(String args[]){
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
