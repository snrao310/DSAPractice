import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 1/20/2017.
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */
public class ValidateBinarySearchTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
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

    private static void inOrder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> traversed=new ArrayList<>();
        inOrder(root,traversed);
        for(int i=1;i<traversed.size();i++){
            if(traversed.get(i)<=traversed.get(i-1))
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(isValidBST(root));
    }
}
