import java.util.List;

/**
 * Created by snrao on 12/27/16.
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */
public class ConvertSortedListToBSTLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val=val;}
    }

    static ListNode list=null;

    //O(nlogn) method analogous to how we would do in arrays. In arrays it would be O(n) coz no need to traverse to find
    //center element.
    public static TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);

        ListNode l1=head,l2=head.next.next;
        while (l2!=null && l2.next!=null){
            l1=l1.next;
            l2=l2.next.next;
        }
        ListNode list=l1.next;
        l1.next=null;
        TreeNode root=new TreeNode(list.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(list.next);
        return root;
    }

    //O(n) algorithm. Bottom-up filling of tree.
    public static TreeNode sortedListToBST2(ListNode head){
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        list=head;
        return helper(0,n-1);
    }

    private static TreeNode helper(int start, int end){
        if(start>end) return null;
        int mid=(start+end)/2;
        TreeNode left=helper(start,mid-1);     //when this returns list will be pointing to mid index
        TreeNode parent=new TreeNode(list.val);     //So we use the list value to make it the parent.
        parent.left=left;
        list=list.next;
        parent.right=helper(mid+1,end);
        return parent;
    }

    public static void inOrder(TreeNode node){
        if(node==null)
            return;
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }

    public static void main(String args[]){
        ListNode one=new ListNode(2);
        one.next=new ListNode(3);
        one.next.next=new ListNode(5);
        one.next.next.next=new ListNode(6);
        one.next.next.next.next=new ListNode(7);
        one.next.next.next.next.next=new ListNode(9);

        TreeNode root=sortedListToBST2(one);
        inOrder(root);
    }
}
