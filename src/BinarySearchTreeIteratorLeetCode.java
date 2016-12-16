import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by S N Rao on 12/16/2016.
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 */
public class BinarySearchTreeIteratorLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }


    //Iterator using stack.
    public static class BSTIterator {

        Stack<TreeNode> st;

        public BSTIterator(TreeNode root) {
            st=new Stack();
            if(root==null)
                return;

            st.push(root);
            TreeNode curr=root;
            while(curr.left!=null){
                st.push(curr.left);
                curr=curr.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !st.empty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode ret=st.pop();
            if(ret.right!=null){
                TreeNode curr=ret.right;
                st.push(curr);
                while(curr.left!=null){
                    st.push(curr.left);
                    curr=curr.left;
                }
            }
            return ret.val;
        }
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

    public static void main(String args[]){
        TreeNode root=createTree();
        BSTIterator i = new BSTIterator(root);
        int j=0;
        int v[]=new int[5];
        while (i.hasNext()) {v[j] = i.next();j++;}
        for(j=0;j<v.length;j++)
            System.out.print(v[j]+" ");
    }
}
