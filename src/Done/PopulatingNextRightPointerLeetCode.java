package Done;

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

    //Level order traversal - works for all binary trees. but not constant space
    public static void connect2(TreeLinkNode root) {
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
    // incomplete tree is given. Also not constant space since its recursion. stack space used is O(logn).
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


    //Iterative O(n) time. Constant space. Best solution Awesome!!! LEVEL ORDER TRAVERSAL is not constant space because
    // it uses the queue. Check DSAPractice2 for neater iterative solution.
    public static void connect(TreeLinkNode root) {
        TreeLinkNode cur=root;
        while (cur!=null){
            TreeLinkNode prev=null;
            TreeLinkNode first=null;
            while(cur!=null){
                if(cur.left!=null){
                    if(prev==null)
                        first=cur.left;
                    else
                        prev.next=cur.left;
                    prev=cur.left;
                }
                if(cur.right!=null){
                    if(prev==null)
                        first=cur.right;
                    else
                        prev.next=cur.right;
                    prev=cur.right;
                }
                cur=cur.next;
            }
            cur=first;
        }
    }

    public static void check(TreeLinkNode root){
        Queue<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode prev=null;
        while(!queue.isEmpty()){
            TreeLinkNode cur=queue.poll();
            if(prev==null){
                TreeLinkNode temp=cur;
                while(temp!=null){
                    System.out.print(temp.val+" ");
                    temp=temp.next;
                }
                System.out.println();
            }
            if(cur!=null){
                if(cur.left!=null)
                    queue.offer(cur.left);
                if(cur.right!=null)
                    queue.offer(cur.right);
            }
            else{
                if(!queue.isEmpty())
                    queue.offer(null);
            }
            prev=cur;
        }
    }

    public static void main(String args[]) {
        TreeLinkNode root=createTree();
        connect(root);
        check(root);
    }
}
