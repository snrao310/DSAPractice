import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by S N Rao on 2/14/2017.
 *
 * You need to find the largest value in each row of a binary tree.
 *
 */
public class FindLargestValueInEachTreeRowLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode createTree(){
        TreeNode five=new TreeNode(5);
        TreeNode minusfive=new TreeNode(-5);
        TreeNode two=new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode root=new TreeNode(2);
        TreeNode fouragain=new TreeNode(4);
        TreeNode minusfour=new TreeNode(-4);
        root.left=four;root.right=five;five.left=two;five.right=minusfive;four.left=minusfour;minusfour.left=fouragain;
        return root;
    }

    //Standard levelorder traversal
    public static List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> result=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                max=Math.max(max,cur.val);
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            else{
                result.add(max);
                max=Integer.MIN_VALUE;
                if(!queue.isEmpty())
                    queue.offer(null);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        List<Integer> list = largestValues(root);
        for(int i:list)
            System.out.print(i+" ");
    }

}
