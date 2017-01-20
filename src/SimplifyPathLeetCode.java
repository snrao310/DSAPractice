import java.util.Stack;

/**
 * Created by S N Rao on 1/20/2017.
 *
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 */
public class SimplifyPathLeetCode {

    public static String simplifyPath(String path) {
        String cur="";
        path+="/";
        Stack<String> stack=new Stack<>();
        Stack<String> stackRev=new Stack<>();
        for(int i=0;i<path.length();i++){
            char ch=path.charAt(i);
            if(ch=='/'){
                if(cur.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }
                else if(!cur.equals("") && !cur.equals("."))
                    stack.push(cur);
                cur="";
            }
            else
                cur+=ch;
        }
        cur="";
        while(!stack.isEmpty())stackRev.push(stack.pop());
        while(!stackRev.isEmpty())cur+="/"+stackRev.pop();
        if(cur.equals("")) return "/";
        return cur;
    }

    public static void main(String args[]){
        System.out.println(simplifyPath("/..."));
    }
}
