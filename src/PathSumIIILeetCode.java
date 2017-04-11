/**
 * Created by S N Rao on 4/10/2017.
 *
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent
 * nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *          10
 *         /  \
 *        5   -3
 *      / \    \
 *     3   2   11
 *    / \   \
 *   3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 */
public class PathSumIIILeetCode {

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
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
    }

    public static int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return findPaths(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private static int findPaths(TreeNode root,int sum){
        int res=0;
        if(root==null) return 0;
        if(root.val==sum) res++;
        res+=findPaths(root.left,sum-root.val);
        res+=findPaths(root.right,sum-root.val);
        return res;
    }

    public static void main(String args[]){
        System.out.print(pathSum(createTree(),4));
    }
}
