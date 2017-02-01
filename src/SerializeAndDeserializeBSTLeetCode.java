import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 2/1/2017.
 *
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be
 * serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
 * should be stateless.
 *
 */
public class SerializeAndDeserializeBSTLeetCode {

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
            String inOrder="",preOrder="";
            List<Integer> in=new ArrayList<>();
            inOrder(root,in);
            List<Integer> pre=new ArrayList<>();
            preOrder(root,pre);
            for(int i: in) inOrder+=","+i;
            System.out.println();
            for(int i: pre) preOrder+=","+i;
            if(inOrder.length()==0) return "";
            return inOrder.substring(1)+" "+preOrder.substring(1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length()==0) return null;
            String[] orders=data.split(" ");
            String[] pre=orders[1].split(","), in=orders[0].split(",");
            int[] preOrder=new int[pre.length], inOrder=new int[in.length];
            for(int i=0;i<in.length;i++) inOrder[i]=Integer.parseInt(in[i]);
            for(int i=0;i<pre.length;i++) preOrder[i]=Integer.parseInt(pre[i]);
            return construnctFromTraversal(inOrder,preOrder,0,in.length-1,0,pre.length-1);
        }

        private TreeNode construnctFromTraversal(int[] inOrder,int[] preOrder, int inStart,int inEnd, int preStart, int preEnd){
            if(inEnd<inStart) return null;
            int rootVal=preOrder[preStart], ind=-1;
            for(int i=inStart;i<=inEnd;i++){
                if(inOrder[i]==rootVal){
                    ind=i;
                    break;
                }
            }
            int leftLen=ind-inStart, preLeftEnd=preStart+leftLen, preRightStart=preLeftEnd+1;
            TreeNode root=new TreeNode(rootVal);
            root.left=construnctFromTraversal(inOrder,preOrder,inStart,ind-1,preStart+1,preLeftEnd);
            root.right=construnctFromTraversal(inOrder,preOrder,ind+1,inEnd,preRightStart,preEnd);
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
