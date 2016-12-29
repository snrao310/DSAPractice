import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/28/16.
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 */
public class PathSumIILeetCode {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static TreeNode createTree(){
//        TreeNode root=new TreeNode(5);
//        TreeNode four=new TreeNode(4);
//        TreeNode eight= new TreeNode(8);
//        TreeNode eleven=new TreeNode(11);
//        TreeNode thirteen=new TreeNode(13);
//        TreeNode four2=new TreeNode(4);
//        TreeNode five= new TreeNode(5);
//        TreeNode one= new TreeNode(1);
//        TreeNode seven= new TreeNode(7);
//        TreeNode two= new TreeNode(2);
//        root.left=four; root.right=eight; four.left=eleven;
//        eleven.left=seven; eleven.right=two; eight.left=thirteen; eight.right=four2;
//        four2.left=five;four2.right=one;
        TreeNode root=new TreeNode(-2);
        TreeNode child=new TreeNode(-3);
        root.right=child;
        return root;
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        pathSumRecurse(root,sum,new ArrayList<>(),result);
        return result;
    }

    private static void pathSumRecurse(TreeNode root,int sum,List<Integer> temp, List<List<Integer>> list){
        if(root==null) return;
        temp.add(root.val);
        if(root.left==null && root.right==null && root.val==sum) {
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }

        pathSumRecurse(root.left,sum-root.val,temp,list);
        pathSumRecurse(root.right,sum-root.val,temp,list);
        temp.remove(temp.size()-1);
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        List<List<Integer>> list=pathSum(root,-5);
        for(List<Integer> l:list){
            for(int i:l)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
