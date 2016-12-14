/**
 * Created by snrao on 12/13/16.
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */
public class ConvertSortedArrayToBSTLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return createSubTree(nums, 0, nums.length-1);
    }

    public static TreeNode createSubTree(int[] nums, int start, int end){
        if(start==end)
            return new TreeNode(nums[start]);
        if(start>end)
            return null;

        int rootIndex=start+(end-start+1)/2;
        TreeNode root=new TreeNode(nums[rootIndex]);
        root.left=createSubTree(nums,start,rootIndex-1);
        root.right=createSubTree(nums, rootIndex+1,end);
        return root;
    }

    public static void inOrder(TreeNode node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }

    public static void preOrder(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void postOrder(TreeNode node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }

    public static void main(String args[]){
        int[] nums={1,2,3,4,5,6,7,8};
        TreeNode root=sortedArrayToBST(nums);
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

}
