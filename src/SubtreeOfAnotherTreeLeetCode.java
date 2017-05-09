/**
 * Created by S N Rao on 5/9/2017.
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
 * subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
 * also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *          3
 *         / \
 *        4   5
 *       / \
 *      1   2
 * Given tree t:
 *          4
 *         / \
 *        1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 * Example 2:
 * Given tree s:
 *          3
 *         / \
 *        4   5
 *       / \
 *      1   2
 *         /
 *        0
 * Given tree t:
 *          4
 *         / \
 *        1   2
 * Return false.
 *
 */
public class SubtreeOfAnotherTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int x){val=x;}
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        if(isEqual(s,t))
            return true;
        if(isSubtree(s.left,t) || isSubtree(s.right,t))
            return true;
        return false;
    }

    private static boolean isEqual(TreeNode s, TreeNode t){
        if(s==null && t!=null) return false;
        if(s!=null && t==null) return false;
        if(s==null && t==null) return true;
        if(s.val!=t.val) return false;
        if(isEqual(s.left, t.left) && isEqual(s.right,t.right)) return true;
        return false;
    }

    public static void main(String args[]){
        TreeNode a=new TreeNode(1); a.left=new TreeNode(2); a.left.left=new TreeNode(3); a.left.right=new TreeNode(4);
        TreeNode b=new TreeNode(2); b.left=new TreeNode(3); b.right=new TreeNode(4);
        System.out.println(isSubtree(a,b)); //true
        a.left.left.left=new TreeNode(5);
        System.out.println(isSubtree(a,b)); //false
    }
}
