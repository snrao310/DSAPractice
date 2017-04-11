import sun.reflect.generics.tree.Tree;

/**
 * Created by S N Rao on 4/11/2017.
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *      1
 *     / \
 *    2   2
 *     \   \
 *      3    3
 *
 */
public class SymmetricBinaryTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){this.val=val;}
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(isMirrorImage(root.left,root.right)) return true;
        return false;
    }

    private static boolean isMirrorImage(TreeNode node1, TreeNode node2){
        if(node1==null && node2!=null) return false;
        if(node1!=null && node2==null) return false;
        if(node1==null && node2==null) return true;
        if(node1.val==node2.val && isMirrorImage(node1.left,node2.right) && isMirrorImage(node1.right,node2.left)) return true;
        return false;
    }

    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2); root.right=new TreeNode(2);
        System.out.println(isSymmetric(root));
        root.left.left=new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
