import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by snrao on 12/20/16.
 * Given a binary tree. Populate each next pointer to point to its next right node. If there is no next right
 * node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointerLeetCode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static TreeLinkNode createTree(){
        TreeLinkNode root=new TreeLinkNode(3);
        TreeLinkNode one=new TreeLinkNode(1);
        TreeLinkNode two= new TreeLinkNode(2);
        TreeLinkNode four=new TreeLinkNode(4);
        TreeLinkNode five= new TreeLinkNode(5);
        TreeLinkNode six= new TreeLinkNode(6);
        TreeLinkNode seven= new TreeLinkNode(7);
        root.left=one; root.right=five; five.left=four; one.right=two;one.left=six;five.right=seven;
        return root;
    }

    //Level order traversal - works for all binary trees.
    public static void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode prev=null;
        while (!queue.isEmpty()){
            TreeLinkNode curr=queue.poll();
            if(prev!=null)
                prev.next=curr;
            if(curr!=null){
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
            }
            prev=curr;
        }
    }

    //recursive - works only for complete binary trees. For example 9 and 10 wont be connected if the following
    // incomplete tree is given.
    //                             1
    //                           /    \
    //                         2        3
    //                        / \      /  \
   //                        4   5    6    7
   //                       / \           / \
   //                      8   9        10   11
    public static void connect_recursive(TreeLinkNode root){
        if(root==null)
            return;

        if(root.left!=null)
            root.left.next=root.right;
        if(root.right!=null)
            root.right.next=null;


        if(root.next!=null){
            if(root.right!=null && root.next.left!=null)
                root.right.next=root.next.left;
        }

        connect_recursive(root.left);
        connect_recursive(root.right);
    }

    public static void check(TreeLinkNode root){
        List<TreeLinkNode> leftMost=new ArrayList<>();
        TreeLinkNode curr=root;
        while (curr!=null){
            leftMost.add(curr);
            curr=curr.left;
        }
        for(TreeLinkNode nod: leftMost){
            curr=nod;
            while (curr!=null){
                System.out.print(curr.val+" ");
                curr=curr.next;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        TreeLinkNode root=createTree();
        connect(root);
        check(root);
    }
}
