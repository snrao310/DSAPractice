import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by S N Rao on 1/31/2017.
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 *
 */
public class PopulatingNextRightPointersIILeetCode {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {val = x;}
    }

    //BFS solution. O(n) time O(n) space.
    public static void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeLinkNode prev=null;
        while(!queue.isEmpty()){
            TreeLinkNode cur=queue.poll();
            if(cur!=null){
                if(cur.left!=null)  queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            else {
                if(!queue.isEmpty())
                    queue.offer(null);
            }
            if(prev!=null) prev.next=cur;
            prev=cur;
        }
    }

    //Iterative O(n) time. Constant space. Awesome!!! LEVEL ORDER TRAVERSAL CAN BE DONE WITH CONSTANT SPACE
    // IF THERE IS A POINTER TO RIGHT SIBLING.
    public static void connect2(TreeLinkNode root) {
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

    public static TreeLinkNode createTree(){
        TreeLinkNode root=new TreeLinkNode(3);
        TreeLinkNode one=new TreeLinkNode(1);
        TreeLinkNode two= new TreeLinkNode(2);
        TreeLinkNode four=new TreeLinkNode(4);
        TreeLinkNode five= new TreeLinkNode(5);
        root.left=one; root.right=five; five.left=four; one.right=two;
        return root;
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

    public static void main(String args[]){
        TreeLinkNode root=createTree();
        connect2(root);
        check(root);
    }
}
