import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/29/16.
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 */
public class UniqueBinarySearchTreesIILeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static void preOrder(TreeNode node){
        if(node==null)
            return;
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n<1) return new ArrayList<>();
        return generateTrees(1,n);
    }

    private static List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> list=new ArrayList<>();
        if(start>end) {
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftList=generateTrees(start,i-1);
            List<TreeNode> rightList=generateTrees(i+1,end);
            for(TreeNode left:leftList){
                for(TreeNode right:rightList){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
        }
        return list;
    }


    public static void main(String args[]){
        List<TreeNode> list=generateTrees(0);
        for(TreeNode r:list) {
            preOrder(r);
            System.out.println();
        }
    }
}
