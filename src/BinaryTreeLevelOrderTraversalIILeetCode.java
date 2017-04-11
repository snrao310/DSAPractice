import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by S N Rao on 4/10/2017.
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *      / \
 *     9  20
 *   /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 */
public class BinaryTreeLevelOrderTraversalIILeetCode {

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

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root); queue.offer(null);
        List<Integer> tempList=new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                tempList.add(cur.val);
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
                res.add(0,new ArrayList(tempList));
                tempList=new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String args[]){
        List<List<Integer>> list=levelOrderBottom(createTree());
        for(List<Integer> l:list)
            System.out.println(l);
    }
}
