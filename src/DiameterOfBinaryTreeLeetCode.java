/**
 * Created by S N Rao on 3/31/2017.
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is
 * the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterOfBinaryTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
    }

    static int diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        diameter=0;
        maxDepth(root);
        return diameter;
    }

    private static int maxDepth(TreeNode root){
        if(root==null) return -1;
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        diameter=Math.max(diameter,leftDepth+rightDepth+2);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(diameterOfBinaryTree(root));
    }
}
