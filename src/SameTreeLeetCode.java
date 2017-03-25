/**
 * Created by S N Rao on 3/24/2017.
 *
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 */
public class SameTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        if(p==null && q==null) return true;
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public static void main(String args[]){
        TreeNode one=new TreeNode(1); one.left=new TreeNode(2);
        TreeNode two=new TreeNode(1); two.right=new TreeNode(2);
        TreeNode three=new TreeNode(1); three.right=new TreeNode(2);
        System.out.println(isSameTree(one, two));
        System.out.println(isSameTree(three, two));
    }
}
