import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by S N Rao on 2/7/2017.
 *
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined
 * as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is
 * the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 *  Input:
 *
 *     5
 *   /  \
 *  2   -3
 *  return [2, -3, 4], since all the values happen only once, return all of them in any order.
 *
 *  Examples 2
 *  Input:
 *
 *    5
 *  /  \
 * 2   -5
 *  return [2], since 2 happens twice, however -5 only occur once.
 *  Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 */
public class MostFrequentSubtreeSumLeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val=x;}
    }

    private static TreeNode createTree(){
        TreeNode five=new TreeNode(5);
        TreeNode minusfive=new TreeNode(-5);
        TreeNode two=new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode root=new TreeNode(2);
        TreeNode fouragain=new TreeNode(4);
        TreeNode minusfour=new TreeNode(-4);
        root.left=four;root.right=five;five.left=two;five.right=minusfive;two.left=minusfour;minusfour.left=fouragain;
        return root;
    }

    //Hashmap solution. O(n).
    public static int[] findFrequentTreeSum(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> resList=new ArrayList<>();
        HashMap<Integer,Integer> sumFreq=new HashMap<>();
        findSums(root,sumFreq);
        int maxFreq= Collections.max(sumFreq.values());
        for(int i:sumFreq.keySet()){
            if(sumFreq.get(i)==maxFreq)
                resList.add(i);
        }
        int[] result=new int[resList.size()];
        int j=0;
        for(int i:resList)
            result[j++]=i;
        return result;
    }

    private static int findSums(TreeNode node, HashMap<Integer, Integer> sumFreq) {
        if(node==null) return 0;
        int sum= node.val + findSums(node.left,sumFreq)+findSums(node.right,sumFreq);
        sumFreq.put(sum, sumFreq.getOrDefault(sum, 0)+1);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root=createTree();
        int[] res=findFrequentTreeSum(root);
        for(int i:res)
            System.out.print(i+" ");
    }
}
