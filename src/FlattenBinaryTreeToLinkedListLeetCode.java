/**
 * Created by snrao on 12/26/16.
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 */
public class FlattenBinaryTreeToLinkedListLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static void flatten(TreeNode root){
        flattenHelper(root);
    }

    private static TreeNode flattenHelper(TreeNode node){
        if(node==null)
            return null;
        if(node.left==null && node.right==null)
            return node;

        TreeNode connect=flattenHelper(node.left);
        TreeNode end=connect;
        if(node.right!=null)
            end=flattenHelper(node.right);
        if (connect != null) { //same as chacking node.left!=null
            connect.right=node.right;
            node.right=node.left;
        }
        node.left=null;
        return end;
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

    public static void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.val+ " ");
        inOrder(root.right);
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        inOrder(root);
        System.out.println();
        flatten(root);
        inOrder(root);
    }
}
