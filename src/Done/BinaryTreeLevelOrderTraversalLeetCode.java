package Done;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by S N Rao on 1/31/2017.
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 */
public class BinaryTreeLevelOrderTraversalLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                list.add(cur.val);
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            else{
                result.add(new ArrayList(list));
                list.clear();
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return result;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        List<List<Integer>> list=levelOrder(root);
        for(List<Integer> l:list){
            for(int i: l)
                System.out.print(i+" ");
            System.out.println();
        }
    }



}
