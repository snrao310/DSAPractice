/**
 * Created by S N Rao on 4/6/2017.
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 * Input: The root of a Binary Search Tree like this:
 *      5
 *    /   \
 *  2     13
 * Output: The root of a Greater Tree like this:
 *     18
 *   /   \
 * 20     13
 *
 */
public class ConvertBSTToGreaterTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(5);
        TreeNode two=new TreeNode(2);
        TreeNode thirteen=new TreeNode(13);
        root.left=two; root.right=thirteen;
        return root;
    }

    public static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }



    static int curSum;

    public static TreeNode convertBST(TreeNode root) {
        curSum=0;
        reverseInOrder(root);
        return root;
    }

    private static void reverseInOrder(TreeNode root){
        if(root==null) return;
        reverseInOrder(root.right);
        curSum+=root.val;
        root.val=curSum;
        reverseInOrder(root.left);
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        inOrder(root);
        System.out.println();

        convertBST(root);
        inOrder(root);
    }
}
