import java.util.List;

/**
 * Created by S N Rao on 1/31/2017.
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
 * changed.
 *
 */
public class SwapNodesInPairsLeetCode {

    private static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode head0=new ListNode(-1);
        head0.next=head;
        ListNode t0=head0,t1=head,t2=head.next,t3=t2.next;
        while (t1!=null && t2!=null){
            t0.next=t2;
            t2.next=t1;
            t1.next=t3;

            t0=t1; t1=t3;
            t2=(t1==null)?null:t1.next;
            t3=(t2==null)?null:t2.next;
        }
        return head0.next;
    }

    public static void main(String args[]){
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(9);
        head.next.next.next=new ListNode(10);
        head.next.next.next.next=new ListNode(12);
        head=swapPairs(head);
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
