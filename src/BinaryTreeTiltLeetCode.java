/**
 * Created by S N Rao on 4/24/2017.
 *
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the
 * sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *      1
 *    /   \
 *   2     3
 *
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 *
 * Note:
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 *
 */
public class BinaryTreeTiltLeetCode {

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

    static int tilt=0;
    public static int findTilt(TreeNode root) {
        tilt=0;
        sumUp(root);
        return tilt;
    }

    private static int sumUp(TreeNode root){
        if(root==null)return 0;
        int lsum=sumUp(root.left);
        int rsum=sumUp(root.right);
        tilt+=Math.abs(lsum-rsum);
        return lsum+rsum+root.val;
    }

    public static void main(String args[]){
        System.out.print(findTilt(createTree())); //12
    }
}
