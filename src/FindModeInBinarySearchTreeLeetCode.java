import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by S N Rao on 4/11/2017.
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the
 * given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * For example:
 * Given BST [1,null,2,2],
 *      1
 *       \
 *        2
 *       /
 *      2
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to
 * recursion does not count).
 *
 */
public class FindModeInBinarySearchTreeLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){this.val=val;}
    }

    static int curVal,curFreq;
    public static int[] findMode(TreeNode root) {
        curVal=0;curFreq=0;
        int maxFreq=inOrderFindMax(root,0);
        List<Integer> res=new ArrayList<>();

        curVal=0;curFreq=0;
        inOrderStore(root,maxFreq,res);
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++)
            result[i]=res.get(i);
        return result;
    }


    private static int inOrderFindMax(TreeNode root,int maxFreq){
        if(root==null) return maxFreq;
        maxFreq=inOrderFindMax(root.left, maxFreq);
        if(root.val==curVal) curFreq++;
        else {curVal=root.val; curFreq=1;}
        maxFreq=Math.max(maxFreq,curFreq);
        maxFreq=inOrderFindMax(root.right,maxFreq);
        return maxFreq;
    }

    private static void inOrderStore(TreeNode root,int maxFreq,List<Integer> list){
        if(root==null) return;
        inOrderStore(root.left,maxFreq,list);
        if(root.val==curVal) curFreq++;
        else {curVal=root.val; curFreq=1;}
        if(curFreq==maxFreq) list.add(root.val);
        inOrderStore(root.right,maxFreq,list);
    }

    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2); root.right.left=new TreeNode(2);
        System.out.print(Arrays.toString(findMode(root)));
    }
}
