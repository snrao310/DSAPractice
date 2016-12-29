/**
 * Created by snrao on 12/29/16.
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromInorderPostorderLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static void inOrderTraverse(TreeNode node){
        if(node==null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val+" ");
        inOrderTraverse(node.right);
    }


    public static void postOrderTraverse(TreeNode node){
        if(node==null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val+" ");
    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    private static TreeNode buildTree(int[] in, int[] post,int inStart, int inEnd, int posStart, int posEnd){
        if(inStart>inEnd) return null;
        if(inStart==inEnd) return new TreeNode(in[inStart]);

        int root=post[posEnd];
        int index;
        for(index=inStart;index<=inEnd;index++) if(in[index]==root) break;
        int leftSize=index-inStart, rightSize=inEnd-index;
        TreeNode rootNode=new TreeNode(root);
        rootNode.left=buildTree(in,post,inStart,index-1,posStart,posStart+leftSize-1);
        rootNode.right=buildTree(in,post,index+1,inEnd,posStart+leftSize,posEnd-1);
        return rootNode;
    }



    public static void main(String args[]){
        int[] inOrder={6,5,8,3,4,7};
        int[] postOrder={6,8,5,7,4,3};
        TreeNode root=buildTree(inOrder,postOrder);
        inOrderTraverse(root);
        System.out.println();
        postOrderTraverse(root);
    }
}
