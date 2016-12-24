import java.util.Stack;

/**
 * Created by snrao on 12/23/16.
 *
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record
 * the node's value. If it is a null node, we record using a sentinel value such as #.
 *
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a
 * binary tree. Find an algorithm without reconstructing the tree.
 *
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid, for example it could never contain two consecutive
 * commas such as "1,,3".
 *
 */
public class VerifyPreorderSerializationBinaryTreeLeetCode {

    public static boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length()==0)
            return false;
        if(preorder.equals("#"))
            return true;

        int i=1;
        Stack<Integer> stack=new Stack<>();
        String[] parts=preorder.split(",");
        if(parts[0].equals("#"))
            stack.push(null);
        else
            stack.push(Integer.parseInt(parts[0]));

        while (!stack.isEmpty() && i<parts.length){
            Integer curr;
            if(parts[i].equals("#")) {
                curr = null;
                while (!stack.isEmpty() && stack.peek()==null){
                    if(stack.size()<2)
                        return false;
                    stack.pop();
                    stack.pop();
                }
            }
            else
                curr=Integer.parseInt(parts[i]);

            stack.push(curr);
            i++;
        }
        if(stack.size()==1 && stack.peek()==null && i==parts.length)
            return true;
        else
            return false;
    }


    public static void main(String args[]){
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("9,#,#,1"));
        System.out.println(isValidSerialization("#,#"));
    }
}
