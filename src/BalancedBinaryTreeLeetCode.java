/**
 * Created by S N Rao on 4/14/2017.
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 *
 */
public class BalancedBinaryTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static boolean isBalanced(TreeNode root) {
        return findHeight(root)!=-1;
    }

    private static int findHeight(TreeNode node){
        if(node==null) return 0;

        int left= findHeight(node.left);
        int right= findHeight(node.right);

        if(left==-1 || right==-1) return -1;
        else if(Math.abs(left-right)>1) return -1;
        else return Math.max(left, right)+1;
    }

    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2); root.right=new TreeNode(3); root.left.right=new TreeNode(5);
        System.out.print(isBalanced(root));
    }
}
