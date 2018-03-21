package Done;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 */
public class KthSmallestElementInABSTLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){val = x;}
    }

    static int pos = 0;

    public static int kthSmallest(TreeNode root, int k) {
        return kthSmallestNode_iterativeInorder(root,k).val;
    }


    public static TreeNode kthSmallestNode_recursiveInorder(TreeNode root, int k) {
        if(root==null) return null;

        TreeNode left = kthSmallestNode_recursiveInorder(root.left,k);
        if(left!=null) return left;

        pos++;
        if(pos==k) return root;

        TreeNode right = kthSmallestNode_recursiveInorder(root.right,k);
        if(right!=null) return right;

        return null;
    }


    public static TreeNode kthSmallestNode_iterativeInorder(TreeNode root, int k) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int pos =0; TreeNode cur=root;

        while(!stack.isEmpty()){
            if(cur!=null && cur.left!=null){
                stack.push(cur.left);
                cur=cur.left;
            }
            else{
                cur=stack.pop();
                pos++;
                if(pos==k) return cur;
                if(cur.right!=null)
                    stack.push(cur.right);
                cur=cur.right;
            }
        }
        return null;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        root.left= new TreeNode(1);
        root.right= new TreeNode(5);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        System.out.println(kthSmallest(root,3));
    }
}
