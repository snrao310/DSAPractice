import java.util.Stack;

/**
 * Created by S N Rao on 4/19/2017.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class ValidParenthesesLeetCode {

    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(stack.isEmpty()){
                if((c==')' || c==']'|| c=='}')) return false;
                else stack.push(c);
                continue;
            }

            char prev=stack.peek();
            if((prev=='(' && c==')') || (prev=='[' && c==']') || (prev=='{' && c=='}')) stack.pop();
            else if(c==')' || c==']' || c=='}') return false;
            else stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String args[]){
        System.out.println(isValid("({{{}}([])})")); //true
        System.out.println(isValid("({{{}}([]))}")); //false
    }
}
