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



    //To construct a BST, we only need either preorder or postorder. We can't do it with inorder because it will always be just a sorted sequence.
    //While constructing with preorder, we need to look for first element greater than this number in the sequence which will be the start of the right tree.
    //Finding this in each call will be an overhead, so we are using a global variable and just exiting when greater value is found. The calling function will
    //thus have the index of the first greater number.
    //Same with postorder but we will start from right and look for first smaller number on the left to know where the left subtree starts.
    public static class Codec {

        int deserializeInd=0;

        // Encodes a tree to a single string.
        private void preorder(TreeNode root, StringBuilder sb){
            if(root==null) return;
            sb.append(root.val+",");
            preorder(root.left,sb);
            preorder(root.right,sb);
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb=new StringBuilder();
            preorder(root,sb);
            if(sb.length()!=0) sb.deleteCharAt(sb.length()-1);
            return sb.toString();
        }

        private TreeNode createSubtree(int[] data, int max){
            if(deserializeInd>=data.length || (deserializeInd<data.length && data[deserializeInd]>max)) return null;
            TreeNode root=new TreeNode(data[deserializeInd++]);
            root.left = createSubtree(data,root.val);
            root.right = createSubtree(data,max);
            return root;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.length()==0) return null;
            String[] parts= data.split(",");
            int[] intParts = new int[parts.length];
            for(int i=0;i<parts.length;i++) intParts[i]=Integer.parseInt(parts[i]);
            deserializeInd=0;
            return createSubtree(intParts,Integer.MAX_VALUE);
        }
    }

    public static void main(String args[]){
        TreeNode root=null;
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
