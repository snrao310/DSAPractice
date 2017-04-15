import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 4/14/2017.
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 *      1
 *    /   \
 *   2     3
 *    \
 *     5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 *
 */
public class BinaryTreePathsLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        if(root==null) return res;
        getPaths(root,res,"");
        return res;
    }

    //Using immutability of strings.
    private static void getPaths(TreeNode node, List<String> list, String cur){
        cur+=node.val;
        if(node.left==null && node.right==null){
            list.add(cur);
            return;
        }
        if(node.left!=null)
            getPaths(node.left,list,cur+"->");
        if(node.right!=null)
            getPaths(node.right,list,cur+"->");
    }


    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2); root.right=new TreeNode(3); root.left.right=new TreeNode(5);
        System.out.print(binaryTreePaths(root));
    }
}
