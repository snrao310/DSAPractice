/**
 * Created by snrao on 12/30/16.
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 */
public class ReverseLinkedListIILeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null || m==n) return head;
        ListNode fprev=null,first=head,sprev=null,second=head;
        for(int i=1;i<n;i++){
            sprev=second;
            second=second.next;
            if(i<m) {
                fprev=first;
                first=first.next;
            }
            else {
                if(fprev==null)
                    head=second;
                else
                    fprev.next = second;
                sprev.next=second.next;
                second.next=first;
                first=second;
                second=sprev;
            }
        }
        return head;
    }

    public static void main(String args[]){
        ListNode one=new ListNode(2);
        one.next=new ListNode(3);
        one.next.next=new ListNode(5);
        one.next.next.next=new ListNode(6);
        one.next.next.next.next=new ListNode(7);
        one.next.next.next.next.next=new ListNode(9);
        one=reverseBetween(one,2,5);
        while (one!=null){
            System.out.print(one.val+" ");
            one=one.next;
        }
    }
}
