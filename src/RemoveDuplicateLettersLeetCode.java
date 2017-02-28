import java.util.Stack;

/**
 * Created by S N Rao on 2/27/2017.
 *
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and
 * only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example:
 * Given "bcabc"
 * Return "abc"
 *
 * Given "cbacdcbc"
 * Return "acdb"
 *
 */
public class RemoveDuplicateLettersLeetCode {

    public static String removeDuplicateLetters(String s) {
        Stack<Integer> stack=new Stack();
        int[] count=new int[26];
        boolean[] inStack=new boolean[26];
        char[] str=s.toCharArray();
        for(char c:str)
            count[c-'a']++;

        for(char c:str){
            count[c-'a']--;
            if(inStack[c-'a']) continue;

            while(!stack.isEmpty() && stack.peek()>c-'a' && count[stack.peek()]>0){
                inStack[stack.pop()]=false;
            }

            stack.push(c-'a');
            inStack[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
            sb.append((char)(stack.pop()+'a'));

        return sb.reverse().toString();
    }

    public static void main(String args[]){
        System.out.print(removeDuplicateLetters("cbacdcbc"));
    }
}
