/**
 * Created by snrao on 12/26/16.
 *
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the
 * root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 */
public class DeleteNodeBSTLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        root.left = three;
        root.right = six;
        three.left = two;
        three.right = four;
        six.right = seven;
        return root;
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        //key=root.val
        if (root.left == null && root.right == null)
            return null;
        if (root.left == null)
            return root.right;
        if(root.right==null)
            return root.left;

        //if both left and right are not null
        TreeNode prevVal=root.left;
        while(prevVal.right!=null) {    //Finding maximum value in left subtree.
            prevVal = prevVal.right;
        }
        root.val=prevVal.val;
        root.left=deleteNode(root.left,prevVal.val);
        return root;
    }

    public static void main(String args[]) {
        TreeNode root = createTree();
        inOrder(root);
        System.out.println();
        root = deleteNode(root, 3);
        inOrder(root);
    }
}
