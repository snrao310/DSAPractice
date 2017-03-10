import sun.reflect.generics.tree.Tree;

/**
 * Created by S N Rao on 3/10/2017.
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two
 * nodes.
 *
 * Example:
 * Input:
 *  1
 *   \
 *    3
 *   /
 *  2
 *
 *  Output:
 *  1
 *
 *  Explanation:
 *  The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *  Note: There are at least two nodes in this BST.
 *
 */
public class MinimumAbsoluteDifferenceInBSTLeetCode {

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

    static int minDifference,prevVal;
    public static int getMinimumDifference(TreeNode root) {
        minDifference=prevVal=Integer.MAX_VALUE;
        inOrderDifference(root);
        return minDifference;
    }

    private static void inOrderDifference(TreeNode node){
        if(node==null) return;
        inOrderDifference(node.left);
        minDifference=Math.min(minDifference,Math.abs(node.val-prevVal));
        prevVal=node.val;
        inOrderDifference(node.right);
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        int i=getMinimumDifference(root);
        System.out.print(i);
    }
}
