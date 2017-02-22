/**
 * Created by S N Rao on 2/22/2017.
 *
 * Invert a binary tree (Mirror Image: left child must become right and right must become left for each node).
 *
 */
public class InvertBinaryTreeLeetCode {

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

    public static void inOrderTraverse(TreeNode node){
        if(node==null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val+" ");
        inOrderTraverse(node.right);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        inOrderTraverse(root);
        System.out.println();
        invertTree(root);
        inOrderTraverse(root);
    }
}
