import java.util.*;

/**
 * Created by snrao on 12/27/16.
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 *
 */
public class BinaryTreeZigzagLevelOrderTraversalLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> tempList=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        boolean leftToRight=true;
        Stack<Integer> stack=new Stack<>();
        while (!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr!=null) {
                if (leftToRight)
                    tempList.add(curr.val);
                else
                    stack.push(curr.val);
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            else {
                if(!leftToRight){
                    while(!stack.isEmpty()){
                        tempList.add(stack.pop());
                    }
                }
                result.add(new ArrayList<Integer>(tempList));
                tempList.clear();
                leftToRight= !leftToRight;
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return result;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        List<List<Integer>> list=zigzagLevelOrder(root);
        for(List<Integer> l:list){
            for(int i:l)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
