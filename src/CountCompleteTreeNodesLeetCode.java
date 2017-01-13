/**
 * Created by S N Rao on 1/13/2017.
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level
 * are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 */
public class CountCompleteTreeNodesLeetCode {

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode two= new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five= new TreeNode(5);
        TreeNode six= new TreeNode(6);
        root.left=one; root.right=five; one.left=four; one.right=two; five.left=six;
        return root;
    }

    //Even this got accepted but this computes the height again and again. Not efficient. But still more efficient than
    //using efficient algorithm with Math.pow.
//    public static int countNodes(TreeNode root) {
//        if(root==null) return 0;
//        int l=countLeftHeight(root);
//        int r=countRightHeight(root);
//        if(l==r) return (1<<l)-1; //Math.pow will not get accepted. Takes too long.
//        return countNodes(root.left)+countNodes(root.right)+1;
//    }


    public static int countNodes(TreeNode root){
        return countNodes(root,countLeftHeight(root),countRightHeight(root));
    }



    private static int countNodes(TreeNode root,int l,int r) {
        if(root==null) return 0;
        if(l==r) return (1<<l)-1; //Math.pow will not get accepted. Takes too long.

        int lr=countRightHeight(root.left);
        if(lr==l-1){
            int lnodes=(1<<lr)-1;   //Math.pow will not get accepted. Takes too long.
            int rl=countLeftHeight(root.right);
            return lnodes+countNodes(root.right,rl,r-1)+1;
        }
        else{
            int rnodes=(1<<(l-2))-1;    //Math.pow will not get accepted. Takes too long.
            return countNodes(root.left,l-1,lr)+rnodes+1;
        }
    }

    private static int countLeftHeight(TreeNode node){
        int l=0;
        TreeNode temp=node;
        while (temp!=null){
            temp=temp.left;
            l++;
        }
        return l;
    }

    private static int countRightHeight(TreeNode node){
        int r=0;
        TreeNode temp=node;
        while (temp!=null){
            temp=temp.right;
            r++;
        }
        return r;
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(countNodes(root));
    }
}
