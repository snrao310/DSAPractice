import sun.reflect.generics.tree.Tree;

/**
 * Created by S N Rao on 3/6/2017.
 *
 * Given a binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along
 * the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * For example:
 * Given the below binary tree,
 *
 *      1
 *     / \
 *    2   3
 *
 * Return 6.
 *
 */
public class BinaryTreeMaximumPathSumLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(-2);
        TreeNode one=new TreeNode(1);
        root.left=one;
        return root;
    }

    static int maxVal;
    public static int maxPathSum(TreeNode root) {
        maxVal=Integer.MIN_VALUE;
        maxPathDown(root);
        return maxVal;
    }

    private static int maxPathDown(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(0,maxPathDown(root.left)); //Path going down only.
        int right=Math.max(0,maxPathDown(root.right)); //Path going down only.
        maxVal=Math.max(maxVal, left+right+root.val); //Path that may turn left path, node, right path.
        return Math.max(left,right)+root.val;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(maxPathSum(root));
    }

}
