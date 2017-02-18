import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by S N Rao on 2/17/2017.
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
 * another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to
 * a string and this string can be deserialized to the original tree structure.
 *
 */
public class SerializeAndDeserializeBinaryTreeLeetCode {

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

    public static void inOrder(TreeNode node, List<Integer> list){
        if(node==null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

    public static void preOrder(TreeNode node, List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }


    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "";
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            queue.offer(null);
            StringBuilder sb=new StringBuilder();
            sb.append(root.val+" ");    //Tried with a string. Got time limit exceeded. Coz every time
                                        // changes are made to a string, a whole new string is created.
            while(!queue.isEmpty()){
                TreeNode cur=queue.poll();
                if(cur!=null){
                    if(cur.left!=null) {
                        sb.append(cur.left.val + " ");
                        queue.offer(cur.left);
                    }
                    else
                        sb.append("X ");

                    if(cur.right!=null) {
                        sb.append(cur.right.val + " ");
                        queue.offer(cur.right);
                    }
                    else
                        sb.append("X ");
                }
                else{
                    if(!queue.isEmpty())
                        queue.offer(null);
                }
            }
            return sb.deleteCharAt(sb.length()-1).toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length()==0) return null;
            Queue<TreeNode> queue=new LinkedList<>();
            String[] nodes=data.split(" ");
            TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
            queue.offer(root);
            queue.offer(null);
            int i=1;
            while(!queue.isEmpty()){
                TreeNode cur=queue.poll();
                if(cur!=null){
                    String leftChild=nodes[i++];
                    String rightChild=nodes[i++];
                   if(!leftChild.equals("X")){
                       cur.left=new TreeNode(Integer.parseInt(leftChild));
                       queue.offer(cur.left);
                   }
                    else
                        cur.left=null;

                    if(!rightChild.equals("X")){
                        cur.right=new TreeNode(Integer.parseInt(rightChild));
                        queue.offer(cur.right);
                    }
                    else
                        cur.right=null;

                }
                else{
                    if(!queue.isEmpty())
                        queue.offer(null);
                }
            }
            return root;
        }
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        Codec codec = new Codec();
        root=codec.deserialize(codec.serialize(root));
        List<Integer> in=new ArrayList<>();
        inOrder(root,in);
        List<Integer> pre=new ArrayList<>();
        preOrder(root,pre);
        for(int i: in) System.out.print(i+" ");
        System.out.println();
        for(int i: pre) System.out.print(i+" ");
    }
}
