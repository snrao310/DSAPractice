import java.util.*;

/**
 * Created by S N Rao on 12/16/2016.
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 *
 */
public class BinaryTreeRightSideViewLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    //LevelOrderTraversal
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>(); //This is how to use java queue. Can also use new LinkedList<>();
        q.offer(root); //offer = enqueue;
        q.offer(null);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr!=null){
                if(q.peek()==null)
                    result.add(curr.val);
                if(curr.left!=null)
                    q.offer(curr.left);
                if(curr.right!=null)
                    q.offer(curr.right);
            }
            else {
                if(!q.isEmpty())
                    q.offer(null);
                continue;
            }
        }

        return result;
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

    public static void main(String args[]){
        TreeNode root=createTree();
        List<Integer> l=rightSideView(root);
        for(int j=0;j<l.size();j++)
            System.out.print(l.get(j)+" ");
    }
}
