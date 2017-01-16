import sun.reflect.generics.tree.Tree;

/**
 * Created by S N Rao on 1/15/2017.
 */
public class KthElementInBST {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    public static TreeNode createTree(){
        TreeNode root=new TreeNode(5);
        TreeNode two= new TreeNode(2);
        TreeNode three= new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode six= new TreeNode(6);
        TreeNode eight= new TreeNode(8);
        TreeNode twelve= new TreeNode(12);
        root.left=three; root.right=eight; three.left=two; three.right=four; eight.left=six; eight.right=twelve;
        return root;
    }


    static int count=1;
    public static TreeNode kthElement(TreeNode node, int k){
        if(node==null) return null;
        TreeNode left=kthElement(node.left,k);
        if(left!=null) return left;
        if(count==k)
            return node;
        count++;
        TreeNode right=kthElement(node.right,k);
        if(right!=null)
            return right;
        return null;
    }


    public static void main(String args[]){
        TreeNode root=createTree();
        System.out.print(kthElement(root,2).val);
    }
}
