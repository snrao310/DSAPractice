import sun.reflect.generics.tree.Tree;

/**
 * Created by S N Rao on 3/21/2017.
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 */
public class SumOfLeftLeavesLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
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

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int leftSum=0;
        if(root.left!=null && root.left.left==null && root.left.right==null)
            leftSum+=root.left.val;
        else
            leftSum=sumOfLeftLeaves(root.left);
        int rightSum=sumOfLeftLeaves(root.right);
        return leftSum+rightSum;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(sumOfLeftLeaves(root));
    }
}
