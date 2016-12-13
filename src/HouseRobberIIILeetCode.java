import java.util.HashMap;

/**
 * Created by snrao on 12/12/16.
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance
 * to this area, called the "root." Besides the root, each house has one and only one parent
 * house. After a tour, the smart thief realized that "all houses in this place forms a binary
 * tree". It will automatically contact the police if two directly-linked houses were broken
 * into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class HouseRobberIIILeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode oneAgain=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        TreeNode six= new TreeNode(6);
        TreeNode seven= new TreeNode(7);
        TreeNode eight= new TreeNode(8);
        TreeNode nine= new TreeNode(9);
        root.left=four; root.right=five; four.left=one; four.right=three; five.right=oneAgain;
        return root;
    }

    public static int rob(TreeNode root) {
        HashMap<TreeNode,Integer> map=new HashMap<>();
        return robHelper(root,map);
    }

    //Dynamic programming. Top down approach.
    public static int robHelper(TreeNode node, HashMap<TreeNode,Integer> map){
        if(node==null)
            return 0;
        if(map.containsKey(node))
            return map.get(node);

        int val=0;
        if(node.left!=null)
            val+=(robHelper(node.left.left,map)+robHelper(node.left.right,map));
        if(node.right!=null)
            val+=(robHelper(node.right.left,map)+robHelper(node.right.right,map));
        val+=node.val;

        int finalVal=Math.max(val, (robHelper(node.left,map) + robHelper(node.right,map)));
        map.put(node, finalVal);
        return finalVal;
    }

    
    
    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.println(rob(root));
    }
}
