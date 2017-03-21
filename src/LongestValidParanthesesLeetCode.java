import java.util.Stack;

/**
 * Created by S N Rao on 3/21/2017.
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 */
public class LongestValidParanthesesLeetCode {


    //The workflow of the solution is as below.
    // 1.   Scan the string from beginning to end. If current character is '(', push its index to the stack.
    // 2.   If current character is ')' and the character at the index of the top of stack is '(', we just find a
    //      matching pair so pop from the stack. Otherwise, we push the index of ')' to the stack.
    // 3.   After the scan is done, the stack will only contain the indices of characters which cannot be matched. Then
    //      let's use the opposite side - substring between adjacent indices should be valid parentheses.
    // 4.   If the stack is empty, the whole input string is valid. Otherwise, we can scan the stack to get longest
    //      valid substring as described in step 3.
    // Try the above steps with an example: ")()())".
    //
    // Now, LeetCode gives time limit exceeded if this its done like this. So compute longest valid substring in the
    // first scan itself.
    //
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '(' && !stack.isEmpty() && s.charAt(stack.peek()) == '(')
                stack.pop();
            else {
                if (stack.isEmpty())
                    max = i;
                else
                    max = Math.max(max, i - stack.peek() - 1);
                stack.push(i);
            }
        }
        if(stack.isEmpty()) return s.length();
        max=Math.max(max, s.length()-stack.peek()-1);
        return max;
    }


    // DP Solution: longest[i] stores the longest length of valid parentheses which ens at i.
    // If s[i] is '(', set longest[i] to 0,because any string ending with '(' cannot be a valid one.
    // Else s[i] is ')'
    //      If s[i-1] is '(',
    //              longest[i] = longest[i-2] + 2
    //      Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(',
    //              longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]
    //Return maximum in the longest array.
    //
    public static int longestValidParenthesesDP(String s) {
        if(s.length()==0) return 0;
        int[] longest=new int[s.length()];
        int max=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='(')
                longest[i]=0;
            else{
                if(s.charAt(i-1)=='(') {
                    int old=(i<2)?0:longest[i - 2];
                    longest[i] = 2 + old;
                }
                else{
                    int startPrev=i-longest[i-1];
                    if(longest[i-1]!=0 && startPrev>=1 && s.charAt(startPrev-1)=='(') {
                        int old=((startPrev<2)?0:longest[startPrev - 2]);
                        longest[i] = longest[i - 1] + 2 + old;
                    }
                    else
                        longest[i]=0;
                }
            }
            max=Math.max(max, longest[i]);
        }
        return max;
    }

    public static void main(String args[]) {
        System.out.println(longestValidParentheses("())"));
    }
}