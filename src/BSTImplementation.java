/**
 * Created by S N Rao on 2/4/2017.
 */
public class BSTImplementation {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }

    public static TreeNode insert(TreeNode root, int k){
        if(root==null) return new TreeNode(k);

        if(k>root.val)
            root.right=insert(root.right,k);
        else
            root.left=insert(root.left,k);

        return root;
    }

    public static boolean search(TreeNode root, int k){
        if(root==null) return false;
        if(root.val==k) return true;

        if(k>root.val)
            return search(root.right,k);
        else
            return search(root.left,k);

    }

    public static TreeNode delete(TreeNode root, int k){
        if(root==null) return null;

        if(k<root.val){
            root.left=delete(root.left,k);
            return root;
        }
        else if(k>root.val){
            root.right=delete(root.right,k);
            return root;
        }

        if(root.left==null && root.right==null) return null;
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;

        TreeNode swap=root.left;
        while(swap.right!=null)
            swap=swap.right;
        root.val=swap.val;
        root.left=delete(root.left,swap.val);
        return root;

    }

    public static void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    public static void main(String args[]){
        TreeNode bst=new TreeNode(9);
        bst=insert(bst,5);
        bst=insert(bst,4);
        bst=insert(bst,16);
        bst=insert(bst,12);
        bst=insert(bst,27);
        bst=insert(bst,13);
        bst=insert(bst,15);
        bst=insert(bst,14);

        inOrder(bst);
        System.out.println();
        postOrder(bst);
        System.out.println(search(bst,16));


        delete(bst,16);

        inOrder(bst);
        System.out.println();
        postOrder(bst);
        System.out.println(search(bst,16));
    }

}
