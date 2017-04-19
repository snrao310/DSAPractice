/**
 * Created by S N Rao on 4/19/2017.
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 */
public class MinimumDepthOfBinaryTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        TreeNode six= new TreeNode(6);
        root.left=one; root.right=five; five.left=four; one.right=two; two.left=six;
        return root;
    }

    static int minDepth=Integer.MAX_VALUE;

    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        minDepth=Integer.MAX_VALUE;
        findMinDepth(root,1);
        return minDepth;
    }

    //DFS, basically
    private static void findMinDepth(TreeNode root, int depth){
        if(root.left==null && root.right==null){
            minDepth=depth;
            return;
        }

        if(root.left!=null && depth+1<minDepth) findMinDepth(root.left, depth+1);
        if(root.right!=null && depth+1<minDepth) findMinDepth(root.right, depth+1);
    }

    public static void main(String args[]){
        System.out.print(minDepth(createTree())); //3
    }
}
