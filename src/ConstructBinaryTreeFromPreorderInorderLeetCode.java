/**
 * Created by snrao on 12/29/16.
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromPreorderInorderLeetCode {

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


    public static void preOrderTraverse(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+" ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private static TreeNode buildTree(int[] pre,int[] in, int preStart, int preEnd, int inStart, int inEnd){
        if(inStart>inEnd) return null;
        if(inStart==inEnd) return new TreeNode(in[inStart]);

        int root=pre[preStart];
        int index;
        for(index=inStart;index<=inEnd;index++) if(in[index]==root) break;
        int leftSize=index-inStart,rightSie=inEnd-index;
        TreeNode rootNode=new TreeNode(root);
        rootNode.left=buildTree(pre,in,preStart+1,preStart+leftSize,inStart,index-1);
        rootNode.right=buildTree(pre,in,preStart+leftSize+1,preEnd,index+1,inEnd);
        return rootNode;
    }



    public static void main(String args[]){
        int[] inOrder={6,5,8,3,4,7};
        int[] preOrder={3,5,6,8,4,7};
        TreeNode root=buildTree(preOrder,inOrder);
        inOrderTraverse(root);
        System.out.println();
        preOrderTraverse(root);
    }

}
