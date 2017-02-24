import sun.reflect.generics.tree.Tree;

/**
 * Created by S N Rao on 2/24/2017.
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 */
public class RecoverBinarySearchTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }

    private static TreeNode createTree(){
        TreeNode root=new TreeNode(5);
        TreeNode three=new TreeNode(3);
        TreeNode six=new TreeNode(6);
        TreeNode eight=new TreeNode(8);
        TreeNode four=new TreeNode(4);
        TreeNode twelve=new TreeNode(12);
        root.left=three; three.right=six;root.right=eight;eight.left=four;eight.right=twelve;
        return root;
    }

    private static void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    //This is morris Traversal. Its inorder traversal without using stack or recursion. No extra space. Changes the tree
    //during its runtime but leaves it in the original state at the end.
    public static void morrisTraversal(TreeNode root) {
        while(root!=null){
            TreeNode temp=root.left;
            if(temp!=null){
                while(temp.right!=null && temp.right!=root)
                    temp=temp.right;
                if(temp.right==null) {
                    temp.right = root;
                    root=root.left;
                }
                else{ //temp.right=root
                    System.out.print(root.val+" ");
                    root=root.right;
                    temp.right=null;
                }
            }
            else{
                System.out.print(root.val+" ");
                root=root.right;
            }
        }
    }

    //This method is a slight modification of Morris traversal (the above function). Whenever the printing happens in morris traversal,
    //the order is checked. If the order is not increasing, then the node is stored. The two positions where this
    //happens are swapped in the end.
    public static void recoverTree(TreeNode root) {
        TreeNode prev=null, first=null, second=null;
        while(root!=null){
            TreeNode temp=root.left;
            if(temp!=null){
                while(temp.right!=null && temp.right!=root)
                    temp=temp.right;
                if(temp.right==null) {
                    temp.right = root;
                    root=root.left;
                }
                else{ //temp.right=root
                    ////////////////////////////////////instead of printing
                    if(prev!=null && prev.val>root.val){
                        if(first==null) {
                            first=prev; second=root;
                        }
                        else
                            second=root;
                    }
                    prev=root;
                    //////////////////////////////////////
                    root=root.right;
                    temp.right=null;
                }
            }
            else{
                ////////////////////////////////////instead of printing
                if(prev!=null && prev.val>root.val){
                    if(first==null) {
                        first=prev; second=root;
                    }
                    else
                        second=root;
                }
                prev=root;
                //////////////////////////////////////
                root=root.right;
            }
        }

        //swapping the first and second error nodes.
        if(first!=null && second!=null) {
            int temp=first.val;
            first.val = second.val;
            second.val=temp;
        }
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        inOrder(root);
        System.out.println();
        recoverTree(root);
        System.out.println();
        inOrder(root);
    }
}
