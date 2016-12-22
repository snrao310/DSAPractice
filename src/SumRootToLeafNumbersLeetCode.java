/**
 * Created by snrao on 12/21/16.
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbersLeetCode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = one;
        root.right = five;
        five.left = four;
        one.right = two;
        five.right = six;
        return root;
    }

    public static class MyInteger {
        int val = 0;
    }

    public static int sumNumbers(TreeNode root) {
//        Integer result=new Integer(0);  //won't work since integer is immutable.
//        rootToleaf(root,"",result);     //need to either pass an array, list or some self-defined class.

        if(root==null)
            return 0;
        MyInteger result = new MyInteger();
        rootToleaf(root, "", result);
        return result.val;
    }

    public static void rootToleaf(TreeNode node, String path, MyInteger sum) {

        path += Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            sum.val = sum.val + Integer.parseInt(path);
            return;
        }
        if (node.left != null)
            rootToleaf(node.left, path, sum);       //Strings are immutable. The one passed will be a new string.
        if (node.right != null)
            rootToleaf(node.right, path, sum);      //Strings are immutable. The one passed will be a new string.
    }


    public static void main(String args[]) {
        TreeNode root = createTree();
        System.out.println(sumNumbers(root));
    }
}
