import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by S N Rao on 4/6/2017.
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *      2
 *     / \
 *    1   3
 * Output:
 * 1
 *
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *   /   / \
 *  4   5   6
 *     /
 *    7
 * Output:
 * 7
 *
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 */
public class FindBottomLeftTreeValueLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){val=x;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(5);
        TreeNode two=new TreeNode(2);
        TreeNode thirteen=new TreeNode(13);
        TreeNode four=new TreeNode(4);
        root.left=two; root.right=thirteen; thirteen.left=four;
        return root;
    }

    //This method does BFS and notes first node at each level. Returns what was noted last.
    //Another option is do right to left traversal of each level and return the last node. No need to put null in queue
    //also.
    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int res=root.val;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            else {
                if(!queue.isEmpty()) {
                    queue.offer(null);
                    res = queue.peek().val;
                }
            }
        }
        return res;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(findBottomLeftValue(root));
    }
}
