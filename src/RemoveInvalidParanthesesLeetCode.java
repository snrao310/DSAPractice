import java.util.*;

/**
 * Created by S N Rao on 2/12/2017.
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 *
 */
public class RemoveInvalidParanthesesLeetCode {

    //Basically BFS. The current string is a node. Remove one character from it at a time and add the new strings
    //created into the queue. These are new nodes. Stop at the level where some string is valid.
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(s);
        queue.offer(s);
        queue.offer(null);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur != null) {
                if (isValid(cur)) {
                    while (cur != null) {
                        if (isValid(cur))
                            result.add(cur);
                        cur = queue.poll();
                    }
                    break;
                } else {
                    for (int i = 0; i < cur.length(); i++) {
                        StringBuilder sb = new StringBuilder(cur);
                        String newString = sb.deleteCharAt(i).toString();
                        if (!visited.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                    }
                }
            } else {
                if (!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return result;
    }

    private static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                count++;
            if (ch == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        List<String> list = removeInvalidParentheses("()())()");
        for (String s : list)
            System.out.println(s + " ");
    }

}
